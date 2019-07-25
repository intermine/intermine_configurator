package org.intermine.configurator.config.buildconfig.supplementary;

import io.swagger.model.DataFileProperties;
import io.swagger.model.SourceConfig;
import org.intermine.configurator.config.buildconfig.DataSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project XML entry for the entrez organism supplementary data source
 */
public class EntrezOrganismSupplementaryDataSource implements DataSource {

    /**
     * {@inheritDoc}
     */
    public String getProjectXML(DataFileProperties propertiesForFile, String fileLocation) {
        String snippet = " <source name=\"entrez-organism\" type=\"entrez-organism\" >"
                + "<property name=\"src.data.file\" location=\"organisms.xml\"/>"
                + "</source>";
        return snippet;
    }

    /**
     * {@inheritDoc}
     */
    public String getDataModel() {
        return null;
    }


    /**
     * {@inheritDoc}
     */
    public List<SourceConfig> getSourceConfigs(DataFileProperties dataFileProperties, String fileLocation) {
        return null;
    }

}
