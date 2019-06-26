package org.intermine.configurator.source.supplementary;

import io.swagger.model.DataFilePropertiesResponseAnswers;
import org.intermine.configurator.source.project.AbstractSource;
import org.intermine.configurator.source.config.AbstractConfigGenerator;

import java.util.List;

public class EntrezOrganismSupplementaryDataSource implements AbstractSource {

    public String getProjectXML() {
        String snippet = " <source name=\"entrez-organism\" type=\"entrez-organism\" >\n"
                + "<property name=\"src.data.file\" location=\"organisms.xml\"/>\n"
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
