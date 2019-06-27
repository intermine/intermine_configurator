package org.intermine.configurator;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import org.intermine.configurator.source.config.AbstractConfigGenerator;
import org.intermine.configurator.source.config.ConfigGeneratorFactory;

import java.io.IOException;


/**
 * manages the uploaded data files
 */
public class DataFileManager {

    public static ValidationResponse processDataFile(DataFile dataFile, String pathToFile) {

        String fileName = "";
        String fileFormat = "";

        if (dataFile.getName() != null) {
            fileName = dataFile.getName().toString();
        }
        if (dataFile.getFileFormat() != null) {
            fileFormat = dataFile.getFileFormat().toString();
        }

        // validate file
        boolean isValid = BioValidator.Validate(pathToFile + fileName, fileFormat, true);

        // error if invalid file
        if (!isValid) {
            ValidationResponse validationResponse = new ValidationResponse(false,
                "invalid file", null);
            return validationResponse;
        }

        DataFile.FileFormatEnum fileFormatEnum = DataFile.FileFormatEnum.fromValue(fileFormat);

        DataFileProperties dataFileProperties = new DataFileProperties();
        dataFileProperties.setDataFile(dataFile);

        AbstractConfigGenerator configGenerator = ConfigGeneratorFactory.getDataSourceConfigGenerator(fileFormatEnum);
        if (configGenerator == null) {
            ValidationResponse validationResponse = new ValidationResponse(false,
                    "Error processing file: file format not found", null);
        }
        try {
            configGenerator.generateConfig(dataFileProperties, pathToFile);
        } catch (IOException e) {
            ValidationResponse validationResponse = new ValidationResponse(false,
                    "Error processing file:" + e.getMessage(), null);
            return validationResponse;
        }

        ValidationResponse validationResponse = new ValidationResponse(true, null,
                dataFileProperties);
        return validationResponse;
    }


}