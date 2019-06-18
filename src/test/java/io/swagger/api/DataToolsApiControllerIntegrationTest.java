package io.swagger.api;

import io.swagger.model.DataTool;

import java.util.*;

import org.intermine.configurator.ToolManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataToolsApiControllerIntegrationTest {

    @Autowired
    private DataToolsApi api;

    @Test
    public void dataToolsGetTest() throws Exception {
        ResponseEntity<List<DataTool>> responseEntity = api.dataToolsGet();
        List<DataTool> tools = ToolManager.getAllTools();

        assertNotNull(tools);

        assertTrue(!tools.isEmpty());

        assertEquals(7, tools.size());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
