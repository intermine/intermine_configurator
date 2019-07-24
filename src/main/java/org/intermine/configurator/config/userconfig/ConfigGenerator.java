package org.intermine.configurator.config.userconfig;

import io.swagger.model.DataFileDescriptor;
import io.swagger.model.DataFilePreview;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Interface defining methods needed to define config for a data type.
 */
public interface ConfigGenerator {

    /**
     * @param dataFileProperties for this data file
     */
    void generateConfig(DataFileProperties dataFileProperties, String fileLocation)
        throws IOException;

    /**
     * Get the descriptors for this file, e.g. number of entities
     *
     * @param reader file reader
     * @return List of descriptors, e.g. number of rows
     * @throws IOException if file can't be opened
     */
    List<DataFileDescriptor> getDescriptors(BufferedReader reader) throws IOException;

    /**
     * Based on filetype, get a set of questions and possible answers to present to the user.
     *
     * @param reader file reader
     * @return a set of questions and possible answers to present to the user.
     * @throws IOException if file can't be opened
     */
    List<DataFilePropertiesQuestion> getQuestions(BufferedReader reader) throws IOException;

    /**
     * Show the first snippet of the file. Provide headings for the UI, e.g. "Sequence"
     *
     * In table format for easy display
     *
     * @param reader file reader
     * @return preview of the data file
     * @throws IOException if file can't be opened
     */
    DataFilePreview getFilePreview(BufferedReader reader) throws IOException;
}
