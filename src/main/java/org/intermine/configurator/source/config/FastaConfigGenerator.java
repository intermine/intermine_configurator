package org.intermine.configurator.source.config;

import io.swagger.model.DataFileDescriptor;
import io.swagger.model.DataFilePreview;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesAnswerOption;
import io.swagger.model.DataFilePropertiesQuestion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastaConfigGenerator implements AbstractConfigGenerator {

    private static final List<String> FEATURE_TYPES = new ArrayList<String>();
    private static final Map<String, String> IDENTIFIER_TYPES = new HashMap<>();
    private String headerRow = null;

    public void generateConfig(DataFileProperties dataFileProperties,
                               String fileLocation) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader(fileLocation));

        // file preview has to be first
        dataFileProperties.setFilePreview(getFilePreview(bf));
        dataFileProperties.setQuestions(getQuestions(bf));
        dataFileProperties.setDescriptors(getDescriptors(bf));
    }

    public List<DataFileDescriptor> getDescriptors(BufferedReader reader) throws IOException {
        String line;
        int entityCount = 0;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(">")) {
                entityCount++;
            }
        }

        List<DataFileDescriptor> descriptors = new ArrayList<>();

        DataFileDescriptor descriptor = new DataFileDescriptor();
        descriptor.setAttributeName("Number of entities in the file");
        descriptor.setAttributeValue(String.valueOf(entityCount));

        descriptors.add(descriptor);
        return descriptors;
    }

    public List<DataFilePropertiesQuestion> getQuestions(BufferedReader reader) throws IOException {
        List<DataFilePropertiesQuestion> questions = new ArrayList<>();

        questions.add(getQuestion1());
        questions.add(getQuestion2());
        questions.add(getQuestion3());

        return questions;
    }

    public DataFilePreview getFilePreview(BufferedReader reader) throws IOException {
        DataFilePreview dataFilePreview = new DataFilePreview();
        dataFilePreview.setHeaderLabel("Header");
        dataFilePreview.setSnippetLabel("Sequence");
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(">")) {
                dataFilePreview.setHeaderRow(Arrays.asList(line));
                // needed for display later
                headerRow = line;
            }
            // fast forward to next valid line
            line = reader.readLine();
            // truncate for readability
            if (line.length() > 50) {
                line = line.substring(0, 49);
            }
            dataFilePreview.setFileSnippet(Arrays.asList(line));
            return dataFilePreview;
        }
        return null;
    }

    private DataFilePropertiesQuestion getQuestion1() {
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

    private DataFilePropertiesQuestion getQuestion2() {
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

    private DataFilePropertiesQuestion getQuestion3() {

        String identifier = getIdentifier(headerRow);
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

    private String getIdentifier(String headerRow) {
        if (headerRow == null) {
            return null;
        }
        String[] bits = headerRow.split(" ");
        if (bits.length > 1 && bits[0].startsWith(">")) {
            // >FBgn100001
            return bits[0].substring(1, bits[0].length());
        }
        return null;
    }
}
