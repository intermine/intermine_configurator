package io.swagger.api;

import io.swagger.model.DataTool;
import io.swagger.model.MineConfig;
import io.swagger.model.MineDescriptor;
import io.swagger.model.SupplementaryDataSource;
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
public class MineApiControllerIntegrationTest {

    @Autowired
    private MineApi api;

    @Test
    public void deleteConfigTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<Void> responseEntity = api.deleteConfig(mineId, userId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void getMineConfigTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<MineConfig> responseEntity = api.getMineConfig(mineId, userId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void getMineDescriptorsTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<MineDescriptor> responseEntity = api.getMineDescriptors(mineId, userId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void getMineSupplementaryDataSourcesTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<List<SupplementaryDataSource>> responseEntity = api.getMineSupplementaryDataSources(mineId, userId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void getNewMineTest() throws Exception {
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<UUID> responseEntity = api.getNewMine(userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void mineDataToolsGetTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<List<DataTool>> responseEntity = api.mineDataToolsGet(mineId, userId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void mineDataToolsPostTest() throws Exception {
        List<Object> body = null;
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<Void> responseEntity = api.mineDataToolsPost(body, mineId, userId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void setMineDescriptorsTest() throws Exception {
        MineDescriptor body = new MineDescriptor();
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<Void> responseEntity = api.setMineDescriptors(body, mineId, userId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void setSupplementaryDataSourcesTest() throws Exception {
        List<Object> body = null;
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<Void> responseEntity = api.setSupplementaryDataSources(body, mineId, userId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

}
