package io.swagger.api;

import io.swagger.model.SupplementaryDataSource;

import java.util.*;

import org.intermine.configurator.SupplementarySourceManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplementaryDataSourcesApiControllerIntegrationTest {

    @Autowired
    private SupplementaryDataSourcesApi api;

    @Test
    public void getSupplementaryDataSourcesTest() throws Exception {

        List<SupplementaryDataSource> sources = SupplementarySourceManager.getAllSupplementarySources();
        assertFalse(sources.isEmpty());

        assertEquals(2, sources.size());

        ResponseEntity<List<SupplementaryDataSource>> responseEntity = api.getSupplementaryDataSources();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
