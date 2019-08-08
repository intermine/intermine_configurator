package org.intermine.configurator.config.buildconfig;

import io.swagger.model.DataFileProperties;
import io.swagger.model.SourceConfig;

import java.util.List;

/**
 * Represents a "project" entry in the project XML file.
 *
 * Generates the actual XML snippet needed to run this source in the build. Also includes
 * a data model snippet needed. This can be NULL.
 *
 * @author Julie Sullivan
 */
public interface DataSource
{

    /**
     * Retrieve the project XML entry for this data parser.
     *
     * @param dataFileProperties metadata about this data file
     * @param fileLocation absolute path to data file
     * @return snippet to be added to project XML file
     */
    String getProjectXML(DataFileProperties dataFileProperties, String fileLocation);

    /**
     * If the data source includes data types that are not in the core model, then we need
     * to extend the data model. This method returns the additions.xml needed by this data source.
     *
     * Can be null!
     *
     * @return model XML to be merged into the core model
     */
    String getDataModel();

    /**
     * If the data source includes data types that are not in the core model, then we need
     * to extend the data model. This method returns the additions.xml needed by this data source.
     *
     * Can be null!
     *
     * @param dataFileProperties metadata about this data file
     * @param fileLocation absolute path to data file
     * @return model XML to be merged into the core model
     */
    List<SourceConfig> getSourceConfigs(DataFileProperties dataFileProperties, String fileLocation);
}
