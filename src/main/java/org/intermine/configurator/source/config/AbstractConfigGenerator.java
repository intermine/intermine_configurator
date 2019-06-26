package org.intermine.configurator.source.config;

import io.swagger.model.DataFileDescriptor;
import io.swagger.model.DataFilePreview;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


public interface AbstractConfigGenerator {

    /**
     * @param dataFileProperties for this data file
     */
    void generateConfig(DataFileProperties dataFileProperties, String fileLocation)
        throws IOException;

    List<DataFileDescriptor> getDescriptors(BufferedReader reader) throws IOException;
    List<DataFilePropertiesQuestion> getQuestions(BufferedReader reader) throws IOException;
    DataFilePreview getFilePreview(BufferedReader reader) throws IOException;
}
