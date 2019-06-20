package org.intermine.configurator.sources;


import io.swagger.model.SupplementaryDataSource;


public class PubMedSupplementaryDataSource implements AbstractDataSource {

    SupplementaryDataSource supplementaryDataSource;
    
    public String getProjectXML() {
        String snippet = " <source name=\"update-publications\" type=\"update-publications\" >\n"
                + "<property name=\"src.data.file\" location=\"publications.xml\"/>\n"
                + "</source>\n";
        return snippet;
    }

    public String getDataModel() {
        return null;
    }
}
