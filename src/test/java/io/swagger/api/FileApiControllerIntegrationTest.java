package io.swagger.api;

import io.swagger.model.DataFile;
import io.swagger.model.DataFilePropertiesResponse;

import java.util.UUID;


import io.swagger.model.Organism;
import org.intermine.biovalidator.api.ValidationResult;
import org.intermine.biovalidator.api.ValidatorHelper;
import org.intermine.configurator.DataFileManager;
import org.intermine.configurator.validation.ValidationResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileApiControllerIntegrationTest {

    @Autowired
    private FileApi api;

    @Test
    public void detectFilePropertiesTest() throws Exception {
        UUID userId = java.util.UUID.randomUUID();
        UUID mineId = java.util.UUID.randomUUID();
//        ResponseEntity<DataFileProperties> responseEntity = api.detectFileProperties(body, userId, mineId);

        String pathToFile = getClass().getClassLoader().getResource("test.fa").getPath();

        ValidationResponse validationResponse = DataFileManager.processDataFile(getDummyDataFile(), pathToFile);

        assertEquals(true, validationResponse.isValid);
    }

    @Test
    public void bioValidator() throws Exception {
        String pathToFile = getClass().getClassLoader().getResource("test.fa").getPath();
        String fileFormat = "fasta";

        ValidationResult validationResult = ValidatorHelper.validate(pathToFile, fileFormat, true);
        assertNotNull(validationResult);
        assertTrue(validationResult.isValid());

        pathToFile = getClass().getClassLoader().getResource("bad-char.fa").getPath();

        validationResult = ValidatorHelper.validate(pathToFile, fileFormat, true);
        assertNotNull(validationResult);
        assertFalse(validationResult.isValid());
    }

    @Test
    public void saveFilePropertiesTest() throws Exception {
        DataFilePropertiesResponse body = new DataFilePropertiesResponse();
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        String pathToFile = getClass().getClassLoader().getResource("test.fa").getPath();

        ValidationResponse validationResponse = DataFileManager.processDataFile(getDummyDataFile(), pathToFile);
        assertTrue(validationResponse.isValid);
    }


    private DataFile getDummyDataFile() {
        DataFile dataFile = new DataFile();
        UUID fileId = java.util.UUID.randomUUID();

        dataFile.setName("test.fa");
        dataFile.setFileId(fileId);
        dataFile.setFileFormat(DataFile.FileFormatEnum.FASTA);

        Organism organism = new Organism();
        organism.setName("Homo sapiens");
        organism.setTaxonID(9606);

        dataFile.setOrganism(organism);

        return dataFile;
    }
}
