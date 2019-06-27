package org.intermine.configurator.source.supplementary;


import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesResponseAnswers;
import io.swagger.model.SupplementaryDataSource;
import org.intermine.configurator.source.project.AbstractSource;
import org.intermine.configurator.source.config.AbstractConfigGenerator;

import java.util.List;


public class PubMedSupplementaryDataSource implements AbstractSource {

    SupplementaryDataSource supplementaryDataSource;
    
    public String getProjectXML(DataFileProperties propertiesForFile, String fileLocation) {
        String snippet = " <source name=\"update-publications\" type=\"update-publications\" >"
                + "<property name=\"src.data.file\" location=\"publications.xml\"/>"
                + "</source>\n";
        return snippet;
    }

    public String getDataModel() {
        return null;
    }

    public void setSelectedAnswers(List<DataFilePropertiesResponseAnswers> answers) {
        return;
    }

    public void setConfig(AbstractConfigGenerator source) {
        return;
    }
}
