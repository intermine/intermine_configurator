package org.intermine.configurator.config.userconfig;

import io.swagger.model.DataFile.FileFormatEnum;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ConfigGeneratorFactoryTest {

    @Test
    public void testgetDataSourceConfigGenerator() {
        ConfigGenerator source = ConfigGeneratorFactory.getDataSourceConfigGenerator(FileFormatEnum.FASTA);
        assertTrue(source instanceof FastaConfigGenerator);
    }
}
