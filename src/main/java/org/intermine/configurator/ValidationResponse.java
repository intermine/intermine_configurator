package org.intermine.configurator;

import io.swagger.model.DataFileProperties;

public class ValidationResponse {

    public boolean isValid = false;
    public String errorMessage = "";
    public DataFileProperties dataFileProperties;

    public ValidationResponse(boolean isValid, String errorMessage, DataFileProperties dataFileProperties) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
        this.dataFileProperties = dataFileProperties;
    }

}
