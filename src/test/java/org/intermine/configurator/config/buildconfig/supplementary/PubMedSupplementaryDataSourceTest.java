package org.intermine.configurator.config.buildconfig.supplementary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;



public class PubMedSupplementaryDataSourceTest  {

    @Test
    public void testGetProjectXML() {
        String snippet = " <source name=\"update-publications\" type=\"update-publications\" >"
                + "<property name=\"src.data.file\" location=\"publications.xml\"/>"
                + "</source>\n";

        PubMedSupplementaryDataSource source = new PubMedSupplementaryDataSource();
        assertEquals(snippet, source.getProjectXML(null, null));
    }

    @Test
    public void testGetModel() {
        PubMedSupplementaryDataSource source = new PubMedSupplementaryDataSource();
        assertNull(source.getDataModel());
    }



}
