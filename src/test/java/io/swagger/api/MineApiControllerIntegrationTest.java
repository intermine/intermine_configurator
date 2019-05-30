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
    public void getMineConfigTest() throws Exception {
        String mineId = "mineId_example";
        ResponseEntity<MineConfig> responseEntity = api.getMineConfig(mineId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getMineDescriptorsTest() throws Exception {
        String mineId = "mineId_example";
        ResponseEntity<MineDescriptor> responseEntity = api.getMineDescriptors(mineId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getNewMineTest() throws Exception {
        ResponseEntity<String> responseEntity = api.getNewMine();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void mineDataToolsMineIdGetTest() throws Exception {
        UUID mineId = new UUID();
        ResponseEntity<List<DataTool>> responseEntity = api.mineDataToolsMineIdGet(mineId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void mineDataToolsMineIdPostTest() throws Exception {
        UUID mineId = new UUID();
        ResponseEntity<DataToolResponse> responseEntity = api.mineDataToolsMineIdPost(mineId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void setMineDescriptorsTest() throws Exception {
        MineDescriptor body = new MineDescriptor();
        String mineId = "mineId_example";
        ResponseEntity<Void> responseEntity = api.setMineDescriptors(body, mineId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
