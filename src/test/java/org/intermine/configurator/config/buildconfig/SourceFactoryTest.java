package org.intermine.configurator.config.buildconfig;

import io.swagger.model.DataFile.FileFormatEnum;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



public class SourceFactoryTest {

    @Test
    public void testGetDataSource() {
        DataSource source = SourceFactory.getDataSource(FileFormatEnum.FASTA);
        assertTrue(source instanceof FastaDataSource);
    }
}
