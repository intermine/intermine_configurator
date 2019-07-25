package org.intermine.configurator.config.buildconfig;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesAnswerOption;
import io.swagger.model.DataFilePropertiesQuestion;
import io.swagger.model.Organism;
import io.swagger.model.SourceConfig;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class GffSourceTest {

    String expected = "<source name=\"gff3\" type=\"gff3\" >" + System.lineSeparator()
            + "<property name=\"gff3.taxonId\" value=\"9606\"/>" + System.lineSeparator()
            + "<property name=\"gff3.dataSetTitle\" value=\"gff3 data set\"/>" + System.lineSeparator()
            + "<property name=\"gff3.dataSourceName\" value=\"InterMine import\"/>" + System.lineSeparator()
            + "<property name=\"gff3.seqClsName\" value=\"Chromosome\"/>" + System.lineSeparator()
            + "<property name=\"src.data.dir\" location=\"/tmp/data\"/>" + System.lineSeparator()
            + "</source>" + System.lineSeparator();

    @Test
    public void testgetProjectXML() {
        GFF3DataSource source = new GFF3DataSource();
        DataFileProperties dataFileProperties = new DataFileProperties();

        DataFile dataFile = new DataFile();
        dataFileProperties.setDataFile(dataFile);

        Organism organism = new Organism();
        organism.setTaxonID(9606);
        dataFile.setOrganism(organism);

        List<DataFilePropertiesQuestion> questions = new ArrayList<>();
        dataFileProperties.setQuestions(questions);

        DataFilePropertiesQuestion question1 = getQandA("genePrimaryIdentifier", "H839_RS00005");
        questions.add(question1);

        assertEquals(expected, source.getProjectXML(dataFileProperties, "/tmp/data"));
    }

    private DataFilePropertiesQuestion getQandA(String questionId, String answerId) {
        DataFilePropertiesQuestion question = new DataFilePropertiesQuestion();
        question.setQuestionId(questionId);

        List<DataFilePropertiesAnswerOption> possibleAnswers = new ArrayList<>();
        question.setPossibleAnswers(possibleAnswers);

        DataFilePropertiesAnswerOption answerOption = new DataFilePropertiesAnswerOption();
        possibleAnswers.add(answerOption);
        answerOption.answerId(answerId);
        answerOption.setIsSelected(true);

        return question;
    }

    @Test
    public void testGetModel() {
        GFF3DataSource source = new GFF3DataSource();
        assertNull(source.getDataModel());
    }

    @Test
    public void testGetSourceConfigs() throws Exception {
        GFF3DataSource source = new GFF3DataSource();
        DataFileProperties dataFileProperties = new DataFileProperties();

        DataFile dataFile = new DataFile();
        dataFileProperties.setDataFile(dataFile);

        Organism organism = new Organism();
        organism.setTaxonID(9606);
        dataFile.setOrganism(organism);

        List<DataFilePropertiesQuestion> questions = new ArrayList<>();
        dataFileProperties.setQuestions(questions);

        DataFilePropertiesQuestion question1 = getQandA("genePrimaryIdentifier", "9606.gene.attributes.Dbxref.GeneID=primaryIdentifier");
        questions.add(question1);

        File f = new File(getClass().getClassLoader().getResource("test.gff").toURI());
        String pathToFile = f.getAbsolutePath();

        List<SourceConfig> configs = source.getSourceConfigs(dataFileProperties, pathToFile);
        assertEquals(2, configs.size());

        SourceConfig config0 = configs.get(0);
        if ("gff_config.properties".equals(config0.getFileName())) {
            testGffConfig(config0);
            testSOTerms(configs.get(1));
        } else {
            testSOTerms(config0);
            testGffConfig(configs.get(1));
        }
    }

    private void testGffConfig(SourceConfig config) {
        SourceConfig expectedConfig = new SourceConfig();
        expectedConfig.setFileName("gff_config.properties");
        expectedConfig.setFileContents("9606.gene.attributes.Dbxref.GeneID=primaryIdentifier");
        assertEquals(expectedConfig, config);
    }

    private static final Set<String> EXPECTED_TERMS = new HashSet<>();

    {
        EXPECTED_TERMS.add("transcript");
        EXPECTED_TERMS.add("gene");
        EXPECTED_TERMS.add("region");
        EXPECTED_TERMS.add("exon");
    }

    private void testSOTerms(SourceConfig config) {
        SourceConfig expectedConfig = new SourceConfig();
        expectedConfig.setFileName("so_terms");
        expectedConfig.setFileContents(String.join(System.lineSeparator(), EXPECTED_TERMS));
        assertEquals(expectedConfig, config);
    }
}
