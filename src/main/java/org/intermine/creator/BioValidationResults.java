package org.intermine.creator;


public class BioValidationResults {

    private boolean isValid;
    private int rowCount;
    private String fileSnippet;
    private String errorMessage;


    public BioValidationResults(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setFileSnippet(String fileSnippet) {
        this.fileSnippet = fileSnippet;
    }

    public String getFileSnippet() {
        return fileSnippet;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getResults() {
        StringBuilder sb = new StringBuilder("{");

        sb.append("\"results\":{");
        sb.append("\"isValid\":" + isValid + ",");
        sb.append("\"rowCount\":" + rowCount + ",");
        sb.append("\"fileSnippet\":\"" + fileSnippet + "\"");
        sb.append("\"message\":\"" + errorMessage + "\"");

        sb.append("}");
        sb.append("}");
        return sb.toString();
    }
}
