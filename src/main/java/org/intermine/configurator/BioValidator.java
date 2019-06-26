package org.intermine.configurator;

/**
 * Dummy class to be replaced with library
 */
public class BioValidator {

    /**
     *
     * @param fileFormat Type of file, e.g. GFF, FASTA, CSV or TAB
     * @param fileLocation contents of file to analyse
     * @param strict if TRUE, validate entire file instead of just header
     * @return Results object that contains: whether or not the file is valid
     */
    public static boolean Validate(String fileLocation, String fileFormat, boolean strict) {
        return true;
    }

}
