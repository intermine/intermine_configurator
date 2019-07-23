package org.intermine.configurator.config.userconfig;

import io.swagger.model.DataFileDescriptor;
import io.swagger.model.DataFilePreview;
import io.swagger.model.DataFilePropertiesQuestion;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FastaConfigGeneratorTest {


    @Test
    public void testgetFilePreview() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.fa")));

        FastaConfigGenerator fastaConfigGenerator = new FastaConfigGenerator();
        DataFilePreview preview = fastaConfigGenerator.getFilePreview(reader);
        assertEquals("Header", preview.getHeaderLabel());
        assertEquals("Sequence", preview.getSnippetLabel());
        assertEquals(Arrays.asList("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN"), preview.getFileSnippet());
        assertEquals(Arrays.asList(">ref|NC_000001.11| Homo sapiens chromosome 1, GRCh38.p12 Primary Assembly"), preview.getHeaderRow());
    }

    @Test
    public void testGetDescriptors() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.fa")));

        FastaConfigGenerator fastaConfigGenerator = new FastaConfigGenerator();
        List<DataFileDescriptor> descriptorList = fastaConfigGenerator.getDescriptors(reader);
        assertEquals(1, descriptorList.size());
        DataFileDescriptor descriptor = descriptorList.get(0);
        assertEquals("Number of entities in the file", descriptor.getAttributeName());
        assertEquals("1", descriptor.getAttributeValue());

    }

    @Test
    public void testGetQuestions() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.fa")));

        FastaConfigGenerator fastaConfigGenerator = new FastaConfigGenerator();
        List<DataFilePropertiesQuestion> questions = fastaConfigGenerator.getQuestions(reader);
        assertEquals(3, questions.size());
    }

    @Test
    public void testQuestion1() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.fa")));

        FastaConfigGenerator fastaConfigGenerator = new FastaConfigGenerator();
        DataFilePropertiesQuestion question = fastaConfigGenerator.getQuestion1();
        assertEquals("Sequence Type", question.getQuestionHeader());
        assertEquals("nucleotideOrProtein", question.getQuestionId());
        assertEquals("Does this file contain nucleotides or proteins?", question.getQuestionWording());
        assertEquals(2, question.getPossibleAnswers().size());
    }

    @Test
    public void testQuestion2() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.fa")));

        FastaConfigGenerator fastaConfigGenerator = new FastaConfigGenerator();
        DataFilePropertiesQuestion question = fastaConfigGenerator.getQuestion2();
        assertEquals("Sequence Features", question.getQuestionHeader());
        assertEquals("featureType", question.getQuestionId());
        assertEquals("What type of features are in this file?", question.getQuestionWording());
        assertEquals(7, question.getPossibleAnswers().size());
    }

    @Test
    public void testQuestion3() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.fa")));

        String questionWording = "The first item (e.g.'ref|NC_000001.11|') is a:";

        FastaConfigGenerator fastaConfigGenerator = new FastaConfigGenerator();

        // sets the header
        fastaConfigGenerator.getFilePreview(reader);

        DataFilePropertiesQuestion question = fastaConfigGenerator.getQuestion3();
        assertEquals("Identifier Type?", question.getQuestionHeader());
        assertEquals("identifierType", question.getQuestionId());
        assertEquals(questionWording, question.getQuestionWording());
        assertEquals(4, question.getPossibleAnswers().size());

    }

    @Test
    public void testIdentifier() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.fa")));

        FastaConfigGenerator fastaConfigGenerator = new FastaConfigGenerator();

        String headerRow = ">FBgn001 test this row";

        String identifier= fastaConfigGenerator.getIdentifier(headerRow);
        assertEquals("FBgn001", identifier);
    }
}
