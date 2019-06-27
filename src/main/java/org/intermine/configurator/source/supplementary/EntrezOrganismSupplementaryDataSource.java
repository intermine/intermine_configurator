package org.intermine.configurator.source.supplementary;

import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesResponseAnswers;
import org.intermine.configurator.source.project.AbstractSource;
import org.intermine.configurator.source.config.AbstractConfigGenerator;

import java.util.List;

public class EntrezOrganismSupplementaryDataSource implements AbstractSource {

    public String getProjectXML(DataFileProperties propertiesForFile, String fileLocation) {
        String snippet = " <source name=\"entrez-organism\" type=\"entrez-organism\" >"
                + "<property name=\"src.data.file\" location=\"organisms.xml\"/>"
                + "</source>";
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
