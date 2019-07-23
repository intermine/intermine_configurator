package org.intermine.configurator.config.userconfig;

import io.swagger.model.DataFile.FileFormatEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


public class ConfigGeneratorFactoryTest {

    @Test
    public void testgetDataSourceConfigGenerator() {
        AbstractConfigGenerator source = ConfigGeneratorFactory.getDataSourceConfigGenerator(FileFormatEnum.FASTA);
        assertTrue(source instanceof FastaConfigGenerator);
    }
}
