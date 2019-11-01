package org.intermine.configurator;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import org.intermine.biovalidator.api.Message;
import org.intermine.biovalidator.api.ValidationFailureException;
import org.intermine.biovalidator.api.ValidationResult;
import org.intermine.biovalidator.api.ValidatorHelper;
import org.intermine.configurator.config.userconfig.ConfigGenerator;
import org.intermine.configurator.config.userconfig.ConfigGeneratorFactory;
import org.intermine.configurator.validation.ValidationResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * manages the uploaded data files
 *
 * @author Julie Sullivan
 */
public final class DataFileManager
{
    private DataFileManager() {
        // don't instantiate
    }


    /**
     * Validates the data file using the biovalidator library, and handles the response.
     *
     * @param dataFile metadata about file to validate
     * @param pathToFile absolute path to the actual file
     * @return an object that contains a boolean isValid, and the associated error message, if any.
     */
    public static ValidationResponse processDataFile(DataFile dataFile, String pathToFile) {

        String fileFormat = "";
        if (dataFile.getFileFormat() != null) {
            fileFormat = dataFile.getFileFormat().toString();
        }

        // debug only
        File f = new File(pathToFile);
        if (!f.exists() || f.isDirectory()) {
            ValidationResponse validationResponse = new ValidationResponse(false,
                    "Can't find file. Looked here: '" + pathToFile + "'", null);
            return validationResponse;
        }

        // validate file
        ValidationResult validationResult = null;
        try {
            validationResult = ValidatorHelper.validate(pathToFile, fileFormat, true);
        } catch (ValidationFailureException e) {
            ValidationResponse validationResponse = new ValidationResponse(false, e.getMessage(),
                null);
            return validationResponse;
        }

        // something went wrong.
        if (validationResult == null) {
            ValidationResponse validationResponse = new ValidationResponse(false,
                    "File failed validation", null);
            return validationResponse;
        }

        // file parsed but it's an invalid file. pass along error message
        if (!validationResult.isValid()) {
            List<Message> messages = validationResult.getErrorMessages();
            StringBuilder errorMessage = new StringBuilder();
            for (Message msg : messages) {
                errorMessage.append(msg.getMessage());
            }
            ValidationResponse validationResponse = new ValidationResponse(false,
                "invalid file", null);
            return validationResponse;
        }

        DataFile.FileFormatEnum fileFormatEnum = DataFile.FileFormatEnum.fromValue(fileFormat);
        DataFileProperties dataFileProperties = new DataFileProperties();
        dataFileProperties.setDataFile(dataFile);

        // use factory to get correct config-generator for our filetype
        ConfigGenerator configGenerator = ConfigGeneratorFactory.getDataSourceConfigGenerator(fileFormatEnum);
        if (configGenerator == null) {
            return new ValidationResponse(false,
                    "Error processing file: file format not found", null);
        }

        // generate config
        try {
            configGenerator.generateConfig(dataFileProperties, pathToFile);
        } catch (IOException e) {
            return new ValidationResponse(false,
                    "Error processing file:" + e.getMessage(), null);
        }

        // everything is correct, generated userconfig based on filetype
        ValidationResponse validationResponse = new ValidationResponse(true, null,
                dataFileProperties);
        return validationResponse;
    }

    /**
     * Based on the user params, build the path to specified files.
     *
     * @param userId ID for this user
     * @param fileId ID for file
     * @param baseDir base directory
     * @param fileName name of file
     * @return the full path to the file
     */
    public static String getFilePath(String userId, String fileId, String baseDir, String fileName) {
        return baseDir + "/" + userId + "/data/" + fileId;
    }
}
