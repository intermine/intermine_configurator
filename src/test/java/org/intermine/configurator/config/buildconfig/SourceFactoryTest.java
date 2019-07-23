package org.intermine.configurator.config.buildconfig;

import io.swagger.model.DataFile.FileFormatEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;



public class SourceFactoryTest {

    @Test
    public void testGetDataSource() {
        AbstractSource source = SourceFactory.getDataSource(FileFormatEnum.FASTA);
        assertTrue(source instanceof FastaSource);
    }
}
