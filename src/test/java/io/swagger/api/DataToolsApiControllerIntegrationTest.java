package io.swagger.api;

import io.swagger.model.DataTool;

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
public class DataToolsApiControllerIntegrationTest {

    @Autowired
    private DataToolsApi api;

    @Test
    public void dataToolsGetTest() throws Exception {
        ResponseEntity<List<DataTool>> responseEntity = api.dataToolsGet();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
