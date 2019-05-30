package io.swagger.api;

import io.swagger.model.DataTool;
import io.swagger.model.DataToolResponse;
import io.swagger.model.MineConfig;
import io.swagger.model.MineDescriptor;
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
        ResponseEntity<Void> responseEntity = api.deleteConfig(mineId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void getMineConfigTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        ResponseEntity<MineConfig> responseEntity = api.getMineConfig(mineId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void getMineDescriptorsTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        ResponseEntity<MineDescriptor> responseEntity = api.getMineDescriptors(mineId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void getNewMineTest() throws Exception {
        ResponseEntity<UUID> responseEntity = api.getNewMine();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void mineDataToolsMineIdGetTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        ResponseEntity<List<DataTool>> responseEntity = api.mineDataToolsMineIdGet(mineId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void mineDataToolsMineIdPostTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        DataTool tool = new DataTool();
        tool.setToolId("toolId");
        ResponseEntity<List<DataTool>> responseEntity = api.mineDataToolsMineIdPost(mineId);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void setMineDescriptorsTest() throws Exception {
        MineDescriptor mineDescriptor = new MineDescriptor();
        mineDescriptor.setMineName("tigerMine");
        mineDescriptor.setLicence("myLicence");
        mineDescriptor.setPrivacy(MineDescriptor.PrivacyEnum.PUBLIC);
        UUID mineId = java.util.UUID.randomUUID();
        ResponseEntity<Void> responseEntity = api.setMineDescriptors(mineDescriptor, mineId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
