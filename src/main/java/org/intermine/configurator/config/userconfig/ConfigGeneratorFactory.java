package org.intermine.configurator.config.userconfig;

import io.swagger.model.DataFile;
import io.swagger.model.DataFile.FileFormatEnum;


/**
 * Based on the filetype given by the wizard, return the proper config generator for that type.
 *
 * @author Julie Sullivan
 */
public final class ConfigGeneratorFactory
{
    private ConfigGeneratorFactory() {
        // don't instantiate
    }

    /**
     * based on file format, return the correct class to generate the build config
     * @param fileFormatEnum the file format, e.g. FASTA
     * @return class that can correctly generate config needed for this class
     */
    public static ConfigGenerator getDataSourceConfigGenerator(FileFormatEnum fileFormatEnum) {
        if (fileFormatEnum == null) {
            return null;
        }
        if (DataFile.FileFormatEnum.FASTA.compareTo(fileFormatEnum) == 0) {
            return new org.intermine.configurator.config.userconfig.FastaConfigGenerator();
        }
        if (FileFormatEnum.GFF.compareTo(fileFormatEnum) == 0) {
            return new org.intermine.configurator.config.userconfig.GFF3ConfigGenerator();
        }
        return null;
    }
}
