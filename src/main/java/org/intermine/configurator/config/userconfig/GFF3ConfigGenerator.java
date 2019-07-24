package org.intermine.configurator.config.userconfig;

import io.swagger.model.DataFileDescriptor;
import io.swagger.model.DataFilePreview;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesAnswerOption;
import io.swagger.model.DataFilePropertiesQuestion;
import io.swagger.model.DataFileRow;

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

    private static final List<String> FEATURE_TYPES = new ArrayList<>();
    private static final Map<String, String> IDENTIFIER_TYPES = new HashMap<>();
    private static final List<String> HEADER = new LinkedList<>();

    /**
     * {@inheritDoc}
     */
    public void generateConfig(DataFileProperties dataFileProperties,
                               String fileLocation) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader(fileLocation));

        // file preview has to be first
        dataFileProperties.setFilePreview(getFilePreview(bf));
        dataFileProperties.setQuestions(getQuestions(bf));
        dataFileProperties.setDescriptors(getDescriptors(bf));
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

        questions.add(getQuestion1());
        questions.add(getQuestion2());
        questions.add(getQuestion3());

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

            // line 1
            dataFilePreview.addFileRowsItem(getRows(reader));
            // line 2
            dataFilePreview.addFileRowsItem(getRows(reader));
            return dataFilePreview;
        }
        return null;
    }

    private DataFileRow getRows(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        DataFileRow row = new DataFileRow();
        for (String s : line.split("\t")) {
            row.add(s);
        }
        return row;
    }

    protected DataFilePropertiesQuestion getQuestion1() {
        DataFilePropertiesQuestion question = new DataFilePropertiesQuestion();
        question.setQuestionId("nucleotideOrProtein");
        question.setQuestionHeader("Sequence Type");
        question.setQuestionWording("Does this file contain nucleotides or proteins?");

        DataFilePropertiesAnswerOption answer1 = new DataFilePropertiesAnswerOption();
        answer1.setAnswerId("nucleotide");
        answer1.setAnswerLabel("Nucleotides");
        answer1.setIsDefault(true);

        question.addPossibleAnswersItem(answer1);

        DataFilePropertiesAnswerOption answer2 = new DataFilePropertiesAnswerOption();
        answer2.setAnswerId("protein");
        answer2.setAnswerLabel("Proteins");
        answer2.setIsDefault(false);

        question.addPossibleAnswersItem(answer2);
        return question;
    }

    static {
        FEATURE_TYPES.add("Protein");
        FEATURE_TYPES.add("Transcript");
        FEATURE_TYPES.add("Exon");
        FEATURE_TYPES.add("CDS");
        FEATURE_TYPES.add("UTR");
        FEATURE_TYPES.add("Chromosome");
    }

    protected DataFilePropertiesQuestion getQuestion2() {
        DataFilePropertiesQuestion question = new DataFilePropertiesQuestion();
        question.setQuestionId("featureType");
        question.setQuestionHeader("Sequence Features");
        question.setQuestionWording("What type of features are in this file?");

        DataFilePropertiesAnswerOption answer1 = new DataFilePropertiesAnswerOption();
        answer1.setAnswerId("Gene");
        answer1.setAnswerLabel("Gene");
        answer1.setIsDefault(true);

        question.addPossibleAnswersItem(answer1);

        for (String dataType : FEATURE_TYPES) {
            DataFilePropertiesAnswerOption answer = new DataFilePropertiesAnswerOption();
            answer.setAnswerId(dataType);
            answer.setAnswerLabel(dataType);
            answer.setIsDefault(false);

            question.addPossibleAnswersItem(answer);
        }
        return question;
    }

    static {
        IDENTIFIER_TYPES.put("symbol", "Symbol");
        IDENTIFIER_TYPES.put("name", "Name");
        IDENTIFIER_TYPES.put("primaryAccession", "Accession");
    }

    protected DataFilePropertiesQuestion getQuestion3() {
        String identifier = "";
        String questionWording = null;
        if (identifier != null) {
            questionWording = "The first item (e.g.'" + identifier + "') is a:";
        } else {
            questionWording = "The first item is a:";
        }

        DataFilePropertiesQuestion question = new DataFilePropertiesQuestion();
        question.setQuestionId("identifierType");
        question.setQuestionHeader("Identifier Type?");
        question.setQuestionWording(questionWording);

        DataFilePropertiesAnswerOption answer1 = new DataFilePropertiesAnswerOption();
        answer1.setAnswerId("primaryIdentifier");
        answer1.setAnswerLabel("Identifier");
        answer1.setIsDefault(true);

        question.addPossibleAnswersItem(answer1);

        for (Map.Entry<String, String> entry : IDENTIFIER_TYPES.entrySet()) {
            DataFilePropertiesAnswerOption answer = new DataFilePropertiesAnswerOption();
            answer.setAnswerId(entry.getKey());
            answer.setAnswerLabel(entry.getValue());
            answer.setIsDefault(false);

            question.addPossibleAnswersItem(answer);
        }
        return question;
    }

}
