package org.intermine.configurator.source.project;

import io.swagger.model.DataFile.FileFormatEnum;

public class SourceFactory {

    public static AbstractSource getDataSource(FileFormatEnum fileFormatEnum) {
        if (fileFormatEnum == null) {
            return null;
        }
        if (FileFormatEnum.FASTA.compareTo(fileFormatEnum) == 0){
            return new FastaSourceEntry();
        }
        return null;
    }
}
