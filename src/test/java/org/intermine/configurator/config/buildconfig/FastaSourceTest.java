package org.intermine.configurator.config.buildconfig;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesAnswerOption;
import io.swagger.model.DataFilePropertiesQuestion;
import io.swagger.model.Organism;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class FastaSourceTest {

    String expected = " <source name=\"fasta\" type=\"fasta\" >"
            + "<property name=\"fasta.taxonId\" value=\"9606\"/>"
            + "<property name=\"fasta.dataSetTitle\" value=\"FASTA data set\"/>"
            + "<property name=\"fasta.dataSourceName\" value=\"InterMine import\"/>"
            + "<property name=\"fasta.className\" value=\"org.intermine.model.bio.Gene\"/>"
            + "<property name=\"fasta.classAttribute\" value=\"primaryIdentifier\"/>"
            + "<property name=\"src.data.dir\" location=\"/tmp/data\"/>"
            + "</source>\n";

    @Test
    public void testgetProjectXML() {
        FastaSource source = new FastaSource();
        DataFileProperties dataFileProperties = new DataFileProperties();

        DataFile dataFile = new DataFile();
        dataFileProperties.setDataFile(dataFile);

        Organism organism = new Organism();
        organism.setTaxonID(9606);
        dataFile.setOrganism(organism);

        List<DataFilePropertiesQuestion> questions = new ArrayList<>();
        dataFileProperties.setQuestions(questions);

        DataFilePropertiesQuestion question1 = getQandA("featureType", "Gene");
        questions.add(question1);
        DataFilePropertiesQuestion question2 = getQandA("identifierType", "primaryIdentifier");
        questions.add(question2);

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
        FastaSource source = new FastaSource();
        assertNull(source.getDataModel());
    }

}
