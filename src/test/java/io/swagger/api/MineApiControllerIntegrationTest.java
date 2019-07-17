package io.swagger.api;

import io.swagger.configuration.AppConfig;
import io.swagger.configuration.MineUserConfigRepository;
import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataTool;
import io.swagger.model.MineBuildConfig;
import io.swagger.model.MineDescriptor;
import io.swagger.model.MineUserConfig;
import io.swagger.model.Organism;
import io.swagger.model.SupplementaryDataSource;
import java.util.UUID;

import java.util.*;

import org.intermine.configurator.MineConfigManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MineApiControllerIntegrationTest {

    @Autowired
    private MineApi api;
    MineConfigManager mineConfigManager = new MineConfigManager();

    @Autowired
    MineUserConfigRepository repository;
    @Autowired
    RedisTemplate redisTemplate;

    @Before
    public void setUp() {

        // flush keyspaces
        redisTemplate.delete(MineUserConfig.class);
    }

    @Test
    public void connectionTest() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        RedisTemplate<Object,Object> redisTemplate = (RedisTemplate<Object, Object>) context.getBean("redisTemplate");
        assertEquals("PONG", redisTemplate.getConnectionFactory().getConnection().ping());
    }

    //@Test
    public void deleteConfigTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        MineUserConfig mineUserConfig = new MineUserConfig();
        mineUserConfig.setMineId(mineId);
        mineUserConfig.setUserId(userId);
        repository.save(mineUserConfig);

        Optional<MineUserConfig> opt = repository.findById(mineId.toString());
        assertTrue(opt.isPresent());

        repository.deleteById(mineId.toString());

        opt = repository.findById(mineId.toString());
        assertFalse(opt.isPresent());

//        mineConfigManager.addMineConfig(repository, mineId, userId);
//        assertNotNull(mineConfigManager.getMineConfig(repository, mineId, userId));
//
//        mineConfigManager.removeConfig(repository, mineId, userId);
//        assertNull(mineConfigManager.getMineConfig(repository, mineId, userId));

//        ResponseEntity<Void> responseEntity = api.deleteConfig(mineId, userId);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    //@Test
    public void deleteMineFilePropertiesTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        UUID fileId = java.util.UUID.randomUUID();

        mineConfigManager.addMineConfig(repository, mineId, userId);

        DataFileProperties dataFileProperties = getDummyDataFile(fileId);

        mineConfigManager.addFileProperties(repository, mineId, userId, fileId, dataFileProperties);

        ResponseEntity<Void> responseEntity = api.deleteMineFileProperties(mineId, userId, fileId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    //@Test
    public void getMineBuildConfigTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        mineConfigManager.addMineConfig(repository, mineId, userId);
        assertNotNull(mineConfigManager.getMineBuildConfig(repository, mineId, userId) == null);

        MineDescriptor descriptor = new MineDescriptor();
        descriptor.setMineName("mytestmine");
        mineConfigManager.setMineDescriptor(repository, mineId, userId, descriptor);
        ResponseEntity<MineBuildConfig> responseEntity = api.getMineBuildConfig(mineId, userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    //@Test
    public void getMineDescriptorsTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        mineConfigManager.addMineConfig(repository, mineId,userId);

        ResponseEntity<MineDescriptor> responseEntity = api.getMineDescriptors(mineId, userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    //@Test
    public void getMineFilePropertiesTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        UUID fileId = java.util.UUID.randomUUID();

        mineConfigManager.addMineConfig(repository, mineId,userId);
        mineConfigManager.addFileProperties(repository, mineId, userId, fileId, getDummyDataFile(fileId));

        ResponseEntity<DataFileProperties> responseEntity = api.getMineFileProperties(mineId, userId, fileId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    //@Test
    public void getMineSupplementaryDataSourcesTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        mineConfigManager.addMineConfig(repository, mineId, userId);

        ResponseEntity<List<SupplementaryDataSource>> responseEntity = api.getMineSupplementaryDataSources(mineId, userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    //@Test
    public void getMineUserConfigTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        mineConfigManager.addMineConfig(repository, mineId,userId);

        ResponseEntity<MineUserConfig> responseEntity = api.getMineUserConfig(mineId, userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    //@Test
    public void getNewMineTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();
        ResponseEntity<UUID> responseEntity = api.getNewMine(userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

   // @Test
    public void mineDataToolsGetTest() throws Exception {
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        mineConfigManager.addMineConfig(repository, mineId,userId);

        ResponseEntity<List<DataTool>> responseEntity = api.mineDataToolsGet(mineId, userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    //@Test
    public void mineDataToolsPostTest() throws Exception {
        List<Object> body = null;
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        mineConfigManager.addMineConfig(repository, mineId,userId);

        ResponseEntity<Void> responseEntity = api.mineDataToolsPost(body, mineId, userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    //@Test
    public void setMineDescriptorsTest() throws Exception {
        MineDescriptor body = new MineDescriptor();
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        mineConfigManager.addMineConfig(repository, mineId,userId);

        ResponseEntity<Void> responseEntity = api.setMineDescriptors(body, mineId, userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

   // @Test
    public void setSupplementaryDataSourcesTest() throws Exception {
        List<Object> body = null;
        UUID mineId = java.util.UUID.randomUUID();
        UUID userId = java.util.UUID.randomUUID();

        // didn't add the mine
        try {
            api.setSupplementaryDataSources(body, mineId, userId);
        } catch (IllegalArgumentException e) {
            assertEquals("User or mine ID not found", e.getMessage());
        }

        mineConfigManager.addMineConfig(repository, mineId,userId);

        ResponseEntity<Void> responseEntity = api.setSupplementaryDataSources(body, mineId, userId);
        // didn't add the mine
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


    private DataFileProperties getDummyDataFile(UUID fileId) {

        DataFileProperties dataFileProperties = new DataFileProperties();

        DataFile dataFile = new DataFile();

        dataFile.setName("test.fa");
        dataFile.setFileId(fileId);
        dataFile.setFileFormat(DataFile.FileFormatEnum.FASTA);

        Organism organism = new Organism();
        organism.setName("Homo sapiens");
        organism.setTaxonID(9606);

        dataFile.setOrganism(organism);

        dataFileProperties.setDataFile(dataFile);

        return dataFileProperties;
    }
}
