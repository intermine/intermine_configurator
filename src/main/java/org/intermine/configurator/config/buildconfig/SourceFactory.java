package org.intermine.configurator.config.buildconfig;

import io.swagger.model.DataFile.FileFormatEnum;

/**
 * Based on filetype, gets the correct config generator
 */
public class SourceFactory {

    /**
     * Based on filetype, gets the correct config generator
     * @param fileFormatEnum enum representing filetype, e.g. FASTA
     * @return the class that can generate the appropriate config for filetype
     */
    public static AbstractSource getDataSource(FileFormatEnum fileFormatEnum) {
        if (fileFormatEnum == null) {
            return null;
        }
        if (FileFormatEnum.FASTA.compareTo(fileFormatEnum) == 0){
            return new FastaSource();
        }
        return null;
    }
}
