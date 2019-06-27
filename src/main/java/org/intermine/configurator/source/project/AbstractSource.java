package org.intermine.configurator.source.project;

import io.swagger.model.DataFileProperties;

public interface AbstractSource {

    String getProjectXML(DataFileProperties dataFileProperties, String fileLocation);
    String getDataModel();

}
