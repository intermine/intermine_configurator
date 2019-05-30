package org.intermine.configurator;

/**
 * Dummy class to be replaced with library
 */
public class BioValidator {

    /**
     *
     * @param fileFormat Type of file, e.g. GFF, FASTA, CSV or TAB
     * @param fileContents contents of file to analyse
     * @param strict if TRUE, validate entire file instead of just header
     * @return Results object that contains: whether or not the file is valid
     */
    public static BioValidationResults Validate(String fileFormat, String fileContents, boolean strict) {
        BioValidationResults results = new BioValidationResults(true);
        int rowCount = countLines(fileContents);
        results.setRowCount(rowCount);
        return results;
    }

    private static int countLines(String str){
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }
}
