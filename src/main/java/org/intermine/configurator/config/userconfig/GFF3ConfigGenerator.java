package org.intermine.configurator.config.userconfig;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileDescriptor;
import io.swagger.model.DataFilePreview;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesAnswerOption;
import io.swagger.model.DataFilePropertiesQuestion;
import io.swagger.model.DataFileRow;
import io.swagger.model.Organism;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Generates config (questions, answers etc) needed by the wizard. Will be presented to the user.
 */
public class GFF3ConfigGenerator implements ConfigGenerator {

    private static final List<String> HEADER = new LinkedList<>();
    protected String taxonId;

    /**
     * {@inheritDoc}
     */
    public void generateConfig(DataFileProperties dataFileProperties,
                               String fileLocation) throws IOException {

        DataFile dataFile = dataFileProperties.getDataFile();
        Organism organism = dataFile.getOrganism();
        taxonId = organism.getTaxonID().toString();

        dataFileProperties.setFilePreview(getFilePreview(new BufferedReader(new FileReader(fileLocation))));
        dataFileProperties.setQuestions(getQuestions(new BufferedReader(new FileReader(fileLocation))));
        dataFileProperties.setDescriptors(getDescriptors(new BufferedReader(new FileReader(fileLocation))));
    }

    /**
     * {@inheritDoc}
     */
    public List<DataFileDescriptor> getDescriptors(BufferedReader reader) throws IOException {
        String line;
        int entityCount = 0;
        while ((line = reader.readLine()) != null) {
            if (!line.startsWith("#")) {
                entityCount++;
            }
        }

        List<DataFileDescriptor> descriptors = new ArrayList<>();

        DataFileDescriptor descriptor = new DataFileDescriptor();
        descriptor.setAttributeName("Number of rows in the file");
        descriptor.setAttributeValue(String.valueOf(entityCount));

        descriptors.add(descriptor);
        return descriptors;
    }

    /**
     * {@inheritDoc}
     */
    public List<DataFilePropertiesQuestion> getQuestions(BufferedReader reader) {
        List<DataFilePropertiesQuestion> questions = new ArrayList<>();
        try {
            questions.add(getQuestion1(reader));
        } catch (IOException e) {
            // do nothing
        }
        return questions;
    }

    static {
        HEADER.add("seqid");
        HEADER.add("source");
        HEADER.add("type");
        HEADER.add("start");
        HEADER.add("end");
        HEADER.add("score");
        HEADER.add("strand");
        HEADER.add("phase");
        HEADER.add("attributes");
    }

    /**
     * {@inheritDoc}
     */
    public DataFilePreview getFilePreview(BufferedReader reader) throws IOException {
        DataFilePreview dataFilePreview = new DataFilePreview();
        dataFilePreview.setHeaderRowLabel("Quick preview of your data");
        dataFilePreview.setHeaderRow(HEADER);
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("#")) {
                continue;
            }

            DataFileRow row1 = getRows(reader);
            if (row1 != null) {
                dataFilePreview.addFileRowsItem(row1);
                DataFileRow row2 = getRows(reader);
                if (row2 != null) {
                    dataFilePreview.addFileRowsItem(row2);
                }
            }
            return dataFilePreview;
        }
        return null;
    }

    private DataFileRow getRows(BufferedReader reader) throws IOException {
        DataFileRow row = new DataFileRow();
        String line = reader.readLine();
        if (line != null) {
            for (String s : line.split("\t")) {
                row.add(s);
            }
        }
        return row;
    }

    protected DataFilePropertiesQuestion getQuestion1(BufferedReader reader)
        throws IOException {
        DataFilePropertiesQuestion question = new DataFilePropertiesQuestion();
        question.setQuestionId("genePrimaryIdentifier");
        question.setQuestionHeader("Gene Identifier");
        question.setQuestionWording("Which is the unique identifier for Gene?");

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] lineArray = line.split("\t");
            if (lineArray.length >= 3) {
                String dataType = lineArray[2];
                if ("gene".equals(dataType)) {
                    question.setPossibleAnswers(getPossibleAnswers(lineArray[8]));
                }
            }
        }
        return question;
    }

    private List<DataFilePropertiesAnswerOption> getPossibleAnswers(String column9) {
        List<DataFilePropertiesAnswerOption> possibleAnswers = new ArrayList<>();

//        ID=id1;Parent=rna0;Dbxref=GeneID:100287102,Genbank:NR_046018.2,HGNC:
//        HGNC:37102;gbkey=misc_RNA;gene=DDX11L1;
//        product=DEAD/H-box helicase 11 like 1;transcript_id=NR_046018.2
        String[] attributes = column9.split(";");
        for (String attribute : attributes) {
            String[] keyValuePairs = attribute.split("=");
            if (keyValuePairs.length == 2) {
                if ("gene".equalsIgnoreCase(keyValuePairs[0])) {
                    possibleAnswers.add(getAnswer(taxonId + ".attributes.gene=primaryIdentifier", attribute));
                } else if ("locus_tag".equalsIgnoreCase(keyValuePairs[0])) {
                        possibleAnswers.add(getAnswer(taxonId + ".attributes.locus_tag=primaryIdentifier", attribute));
                } else if ("name".equalsIgnoreCase(keyValuePairs[0])) {
                    possibleAnswers.add(getAnswer(taxonId + ".attributes.name=primaryIdentifier", attribute));
                } else if ("Dbxref".equalsIgnoreCase(keyValuePairs[0])) {
                    String[] dbxrefs = keyValuePairs[1].split(",");
                    for (String dbxref : dbxrefs) {
                        String[] xrefKeyValues = dbxref.split(":");
                        //9606.gene.attributes.Dbxref.GeneID
                        possibleAnswers.add(getAnswer(taxonId + ".gene.attributes.Dbxref." +
                            xrefKeyValues[0] + "=primaryIdentifier", dbxref));

//                        "ID=cds0;Parent=gene0;Dbxref=Genbank:WP_043903292.1;Name=WP_043903292.1;gbkey=CDS;
//                        product=hypothetical protein;protein_id=WP_043903292.1;transl_table=11"

                    }
                }
            }
        }
        return possibleAnswers;
    }

    private DataFilePropertiesAnswerOption getAnswer(String answerId, String answerLabel) {
        DataFilePropertiesAnswerOption answer = new DataFilePropertiesAnswerOption();
        answer.setAnswerId(answerId);
        answer.setAnswerLabel(answerLabel);
        return answer;
    }

}
