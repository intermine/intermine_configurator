package io.swagger.api;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesResponseInner;
import java.util.UUID;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileApiControllerIntegrationTest {

    @Autowired
    private FileApi api;

    @Test
    public void detectFilePropertiesTest() throws Exception {
        DataFile body = new DataFile();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<DataFileProperties> responseEntity = api.detectFileProperties(body, userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void saveFilePropertiesTest() throws Exception {
        List<DataFilePropertiesResponseInner> body = Arrays.asList(new DataFilePropertiesResponseInner());
        UUID userId = java.util.UUID.randomUUID();
        UUID mineId = java.util.UUID.randomUUID();
        ResponseEntity<Void> responseEntity = api.saveFileProperties(body, userId, mineId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
