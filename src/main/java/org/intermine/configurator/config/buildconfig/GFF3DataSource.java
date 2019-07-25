package org.intermine.configurator.config.buildconfig;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesAnswerOption;
import io.swagger.model.DataFilePropertiesQuestion;
import io.swagger.model.DataFileRow;
import io.swagger.model.Organism;
import io.swagger.model.SourceConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * {@inheritDoc}
 */
public class GFF3DataSource implements DataSource {

    Map<String, String> selectedAnswers = new HashMap<>();

    public GFF3DataSource() {
        // constructor
    }

    /**
     * {@inheritDoc}
     */
    public String getProjectXML(DataFileProperties dataFileProperties, String fileLocation) {
        if (dataFileProperties == null) {
            return null;
        }

        DataFile dataFile = dataFileProperties.getDataFile();
        Organism organism = dataFile.getOrganism();
        String taxonId = organism.getTaxonID().toString();

        String snippet = " <source name=\"gff3\" type=\"gff3\" >" + System.lineSeparator()
                + "<property name=\"gff3.taxonId\" value=\"" + taxonId + "\"/>" + System.lineSeparator()
                + "<property name=\"gff3.dataSetTitle\" value=\"gff3 data set\"/>" + System.lineSeparator()
                + "<property name=\"gff3.dataSourceName\" value=\"InterMine import\"/>" + System.lineSeparator()
                + "<property name=\"gff3.seqClsName\" value=\"Chromosome\"/>" + System.lineSeparator()
                + "<property name=\"src.data.dir\" location=\"" + fileLocation + "\"/>" + System.lineSeparator()
                + "</source>" + System.lineSeparator();
        return snippet;
    }

    /**
     * {@inheritDoc}
     */
    public String getDataModel() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public List<SourceConfig> getSourceConfigs(DataFileProperties dataFileProperties, String fileLocation) {

        List<SourceConfig> sourceConfigs = new ArrayList<>();

        // gff_config.properties
        SourceConfig gffConfig = new SourceConfig();
        gffConfig.setFileName("gff_config.properties");
        try {
            gffConfig.setFileContents(getGFFConfig(dataFileProperties));
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't open file " + fileLocation);
        }
        sourceConfigs.add(gffConfig);

        // so_terms
        SourceConfig soTermsConfig = new SourceConfig();
        soTermsConfig.setFileName("so_terms");
        try {
            soTermsConfig.setFileContents(getSOTerms(fileLocation));
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't open file " + fileLocation);
        }
        sourceConfigs.add(soTermsConfig);

        return sourceConfigs;
    }

    // construct GFF config file based on user answers
    private String getGFFConfig(DataFileProperties dataFileProperties) throws IOException {
        if (dataFileProperties == null) {
            return null;
        }
        setSelectedAnswers(dataFileProperties);

        // 9606.gene.attributes.Dbxref.GeneID=primaryIdentifier
        return selectedAnswers.get("genePrimaryIdentifier");
    }

    private void setSelectedAnswers(DataFileProperties dataFileProperties) {
        List<DataFilePropertiesQuestion> questions = dataFileProperties.getQuestions();
        for (DataFilePropertiesQuestion question : questions) {
            List<DataFilePropertiesAnswerOption> possibleAnswers = question.getPossibleAnswers();
            for (DataFilePropertiesAnswerOption possibleAnswer : possibleAnswers) {
                if (possibleAnswer.isIsSelected()) {
                    selectedAnswers.put(question.getQuestionId(), possibleAnswer.getAnswerId());
                }
            }
        }
    }

    // get unique list of data types from gff file
    private String getSOTerms(String fileLocation) throws IOException {
        Set<String> dataTypes = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] lineArray = line.split("\t");
            if (lineArray.length >= 3) {
                String dataType = lineArray[2];
                dataTypes.add(dataType);
            }
        }
        return String.join(System.lineSeparator(), dataTypes);
    }
}
