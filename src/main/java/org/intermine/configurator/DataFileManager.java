package org.intermine.configurator;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import org.intermine.configurator.source.config.AbstractConfigGenerator;
import org.intermine.configurator.source.config.ConfigGeneratorFactory;

import java.io.IOException;
import java.util.UUID;

/**
 * manages the uploaded data files
 */
public class DataFileManager {

    public static ValidationResponse processDataFile(UUID mineId, UUID userId, DataFile dataFile, String pathToFile) {

        String fileName = "";
        UUID fileId = null;
        String fileFormat = "";

        if (dataFile.getName() != null) {
            fileName = dataFile.getName().toString();
        }
        if (dataFile.getFileId() != null) {
            fileId = dataFile.getFileId();
        }
        if (dataFile.getFileFormat() != null) {
            fileFormat = dataFile.getFileFormat().toString();
        }

//

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

        AbstractConfigGenerator configGenerator = ConfigGeneratorFactory.getDataSourceConfig(fileFormatEnum);
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