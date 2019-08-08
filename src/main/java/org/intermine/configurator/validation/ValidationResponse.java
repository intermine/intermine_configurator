package org.intermine.configurator.validation;

import io.swagger.model.DataFileProperties;

/**
 * Object that contains the response from the biovalidator library.
 *
 * @author Julie Sullivan
 */
public class ValidationResponse
{
    private boolean isValid;
    private String errorMessage;
    private DataFileProperties dataFileProperties;

    /**
     * Using the biovalidator library, return the error message (if any) and true/false if pass/
     * failed validation.
     *
     * @param isValid TRUE if this file passed validation.
     * @param errorMessage message from biovalidator library, might be NULL
     * @param dataFileProperties associated properties for this file.
     */
    public ValidationResponse(boolean isValid, String errorMessage,
        DataFileProperties dataFileProperties) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
        this.dataFileProperties = dataFileProperties;
    }

    /**
     * @return TRUE if the biovalidator found no errors in the file.
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * @return Error message (if any) from the biovalidator file.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @return Metadata about file being processed
     */
    public DataFileProperties getDataFileProperties() {
        return dataFileProperties;
    }
}
