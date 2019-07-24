package org.intermine.configurator.config.buildconfig;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesAnswerOption;
import io.swagger.model.DataFilePropertiesQuestion;
import io.swagger.model.Organism;
import io.swagger.model.SourceConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<DataFilePropertiesQuestion> questions = dataFileProperties.getQuestions();
        for (DataFilePropertiesQuestion question : questions) {
            List<DataFilePropertiesAnswerOption> possibleAnswers = question.getPossibleAnswers();
            for (DataFilePropertiesAnswerOption possibleAnswer : possibleAnswers) {
                if (possibleAnswer.isIsSelected()) {
                    selectedAnswers.put(question.getQuestionId(), possibleAnswer.getAnswerId());
                }
            }
        }

        DataFile dataFile = dataFileProperties.getDataFile();
        Organism organism = dataFile.getOrganism();
        String taxonId = organism.getTaxonID().toString();
        String dataType = "org.intermine.model.bio." + selectedAnswers.get("featureType");
        String classAttribute = selectedAnswers.get("identifierType");
        if (classAttribute == null || dataType == null) {
            return null;
        }

        String snippet = " <source name=\"gff\" type=\"gff\" >"
                + "<property name=\"gff3.taxonId\" value=\"" + taxonId + "\"/>"
                + "<property name=\"gff3.dataSetTitle\" value=\"gff3 data set\"/>"
                + "<property name=\"gff3.dataSourceName\" value=\"InterMine import\"/>"
                + "<property name=\"gff3.seqClsName\" value=\"Chromosome\"/>"
                + "<property name=\"src.data.dir\" location=\"" + fileLocation + "\"/>"
                + "</source>\n";
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

        // gff_config.properties
        // TODO based on answers, write new config file

        // so_terms
        // TODO get list of terms from file

        return null;
    }
}
