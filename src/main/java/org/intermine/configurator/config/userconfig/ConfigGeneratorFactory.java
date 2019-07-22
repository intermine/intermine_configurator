package org.intermine.configurator.config.userconfig;

import io.swagger.model.DataFile;
import io.swagger.model.DataFile.FileFormatEnum;


/**
 * Based on the filetype given by the wizard, return the proper config generator for that type.
 */
public class ConfigGeneratorFactory {

    public static AbstractConfigGenerator getDataSourceConfigGenerator(FileFormatEnum fileFormatEnum) {
        if (fileFormatEnum == null) {
            return null;
        }
        if (DataFile.FileFormatEnum.FASTA.compareTo(fileFormatEnum) == 0){
            return new org.intermine.configurator.config.userconfig.FastaConfigGenerator();
        }
        return null;
    }
}
