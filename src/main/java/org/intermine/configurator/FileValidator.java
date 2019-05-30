package org.intermine.configurator;

public abstract class FileValidator {

    // should return a boolean and an error message
    public abstract String Validate(String fileContents);
}
