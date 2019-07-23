package org.intermine.configurator.config.buildconfig.supplementary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EntrezOrganismSupplementaryDataSourceTest {

    @Test
    public void testGetProjectXML() {
        String snippet = " <source name=\"entrez-organism\" type=\"entrez-organism\" >"
                + "<property name=\"src.data.file\" location=\"organisms.xml\"/>"
                + "</source>";

        EntrezOrganismSupplementaryDataSource source = new EntrezOrganismSupplementaryDataSource();
        assertEquals(snippet, source.getProjectXML(null, null));
    }

    @Test
    public void testGetModel() {
        EntrezOrganismSupplementaryDataSource source = new EntrezOrganismSupplementaryDataSource();
        assertNull(source.getDataModel());
    }
}
