package org.intermine.configurator.config.userconfig;

import io.swagger.model.DataFileDescriptor;
import io.swagger.model.DataFilePreview;
import io.swagger.model.DataFilePropertiesAnswerOption;
import io.swagger.model.DataFilePropertiesQuestion;
import io.swagger.model.DataFileRow;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GffConfigGeneratorTest {

    private static final List<String> HEADER = new LinkedList<>();
    private static final List<String> EXPECTEDROW = new LinkedList<>();

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

        EXPECTEDROW.add("NC_000001.11");
        EXPECTEDROW.add("BestRefSeq");
        EXPECTEDROW.add("gene");
        EXPECTEDROW.add("11874");
        EXPECTEDROW.add("14409");
        EXPECTEDROW.add(".");
        EXPECTEDROW.add("+");
        EXPECTEDROW.add(".");
        EXPECTEDROW.add("ID=gene0;Dbxref=GeneID:100287102,HGNC:HGNC:37102;Name=DDX11L1;description=DEAD/H-box helicase 11 like 1;gbkey=Gene;gene=DDX11L1;gene_biotype=transcribed_pseudogene;pseudo=true");
    }


    @Test
    public void testgetFilePreview() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.gff")));

        GFF3ConfigGenerator gffConfigGenerator = new GFF3ConfigGenerator();
        DataFilePreview preview = gffConfigGenerator.getFilePreview(reader);
        assertEquals("Quick preview of your data", preview.getHeaderRowLabel());
        List<DataFileRow> rows = preview.getFileRows();
        DataFileRow row = rows.get(0);
        assertEquals(EXPECTEDROW, row);

        assertEquals(HEADER, preview.getHeaderRow());
    }

    @Test
    public void testGetDescriptors() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.gff")));

        GFF3ConfigGenerator gffConfigGenerator = new GFF3ConfigGenerator();
        List<DataFileDescriptor> descriptorList = gffConfigGenerator.getDescriptors(reader);
        assertEquals(1, descriptorList.size());
        DataFileDescriptor descriptor = descriptorList.get(0);
        assertEquals("Number of rows in the file", descriptor.getAttributeName());
        assertEquals("6", descriptor.getAttributeValue());

    }

    @Test
    public void testGetQuestions() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.gff")));

        GFF3ConfigGenerator gffConfigGenerator = new GFF3ConfigGenerator();
        List<DataFilePropertiesQuestion> questions = gffConfigGenerator.getQuestions(reader);
        assertEquals(1, questions.size());
    }

    private static final List<String> EXPECTED_LABEL = new LinkedList<>();
    private static final List<String> EXPECTED_ANSWER_ID = new LinkedList<>();

    {
        EXPECTED_LABEL.add("GeneID:100287102");
        EXPECTED_LABEL.add("HGNC:HGNC:37102");
        EXPECTED_LABEL.add("DDX11L1");
        EXPECTED_ANSWER_ID.add("9606.gene.attributes.Dbxref.GeneID=primaryIdentifier");
        EXPECTED_ANSWER_ID.add("9606.gene.attributes.Dbxref.HGNC=primaryIdentifier");
        EXPECTED_ANSWER_ID.add("9606.gene.attributes.gene=primaryIdentifier");
    }

    @Test
    public void testQuestion1() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream("test.gff")));

        GFF3ConfigGenerator gffConfigGenerator = new GFF3ConfigGenerator();
        gffConfigGenerator.taxonId = "9606";
        DataFilePropertiesQuestion question = gffConfigGenerator.getQuestion1(reader);
        assertEquals("Gene Identifier", question.getQuestionHeader());
        assertEquals("genePrimaryIdentifier", question.getQuestionId());
        assertEquals(4, question.getPossibleAnswers().size());

        // ID=gene0;Dbxref=GeneID:100287102,HGNC:HGNC:37102;Name=DDX11L1;description=DEAD/H-box helicase 11 like 1;
        // gbkey=Gene;gene=DDX11L1;gene_biotype=transcribed_pseudogene;pseudo=true

        List<DataFilePropertiesAnswerOption> answerOptions = question.getPossibleAnswers();

        DataFilePropertiesAnswerOption answer1 = new DataFilePropertiesAnswerOption();
        answer1.setAnswerId("GeneID:100287102");
        answer1.setAnswerLabel("9606.gene.attributes.Dbxref.GeneID=primaryIdentifier");
        DataFilePropertiesAnswerOption answer2 = new DataFilePropertiesAnswerOption();
        answer2.setAnswerId("GeneID:100287102");
        answer2.setAnswerLabel("9606.gene.attributes.Dbxref.GeneID=primaryIdentifier");
        DataFilePropertiesAnswerOption answer3 = new DataFilePropertiesAnswerOption();
        answer3.setAnswerId("GeneID:100287102");
        answer3.setAnswerLabel("9606.gene.attributes.Dbxref.GeneID=primaryIdentifier");
        List<DataFilePropertiesAnswerOption> expectedAnswerOptions = question.getPossibleAnswers();
        expectedAnswerOptions.add(answer1);
        expectedAnswerOptions.add(answer2);
        expectedAnswerOptions.add(answer3);

        assertEquals(expectedAnswerOptions, answerOptions);
    }
}
