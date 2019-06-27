package org.intermine.configurator.source.config;

import io.swagger.model.DataFile;
import io.swagger.model.DataFile.FileFormatEnum;

public class ConfigGeneratorFactory {

    public static AbstractConfigGenerator getDataSourceConfigGenerator(FileFormatEnum fileFormatEnum) {
        if (fileFormatEnum == null) {
            return null;
        }
        if (DataFile.FileFormatEnum.FASTA.compareTo(fileFormatEnum) == 0){
            return new FastaConfigGenerator();
        }
        return null;
    }
}
