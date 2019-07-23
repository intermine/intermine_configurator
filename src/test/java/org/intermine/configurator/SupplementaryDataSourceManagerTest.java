package org.intermine.configurator;


import io.swagger.model.SupplementaryDataSource;
import org.intermine.configurator.SupplementaryDataSourceManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SupplementaryDataSourceManagerTest {

    @Test
    public void testGetAllSupplementarySources() {
        List<SupplementaryDataSource> sources = SupplementaryDataSourceManager.getAllSupplementarySources();
        assertEquals(2, sources.size());
    }
}
