package org.intermine.configurator;


import io.swagger.model.DataFile;
import org.intermine.configurator.validation.ValidationResponse;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataFileManagerTest {

    @Test
    public void testProcessDataFile() throws Exception {

        DataFile dataFile = new DataFile();
        File f = new File(getClass().getClassLoader().getResource("test.fa").toURI());
        String pathToFile = f.getAbsolutePath();

        // no file format
        try {
            DataFileManager.processDataFile(dataFile, pathToFile);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid validator type", e.getMessage());
        }

        dataFile.fileFormat(DataFile.FileFormatEnum.FASTA);
        ValidationResponse validationResponse = DataFileManager.processDataFile(dataFile, pathToFile);
        assertTrue(validationResponse.isValid);

        f = new File(getClass().getClassLoader().getResource("bad-char.fa").toURI());
        pathToFile = f.getAbsolutePath();

        validationResponse = DataFileManager.processDataFile(dataFile, pathToFile);
        assertFalse(validationResponse.isValid);

    }

    @Test
    public void testgetFilePath() {
        String expected = "baseDir/userId/mineId/fileId/fileName";
        String filePath = DataFileManager.getFilePath("mineId", "userId",
                "fileId", "baseDir", "fileName");
        assertEquals(expected, filePath);
    }
}

