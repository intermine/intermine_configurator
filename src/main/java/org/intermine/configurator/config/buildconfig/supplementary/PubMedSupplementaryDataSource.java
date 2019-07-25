package org.intermine.configurator.config.buildconfig.supplementary;

import io.swagger.model.DataFileProperties;
import io.swagger.model.SourceConfig;
import org.intermine.configurator.config.buildconfig.DataSource;

import java.util.List;


/**
 * Project XML entry for the update-publications supplementary data source
 */
public class PubMedSupplementaryDataSource implements DataSource {

    /**
     * {@inheritDoc}
     */
    public String getProjectXML(DataFileProperties propertiesForFile, String fileLocation) {
        String snippet = " <source name=\"update-publications\" type=\"update-publications\" >"
                + "<property name=\"src.data.file\" location=\"publications.xml\"/>"
                + "</source>\n";
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
