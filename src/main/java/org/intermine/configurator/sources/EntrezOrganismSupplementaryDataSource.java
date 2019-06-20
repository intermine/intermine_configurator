package org.intermine.configurator.sources;

public class EntrezOrganismSupplementaryDataSource implements AbstractDataSource {

    public static String getProjectXML() {
        String snippet = " <source name=\"entrez-organism\" type=\"entrez-organism\" >\n"
                + "<property name=\"src.data.file\" location=\"organisms.xml\"/>\n"
                + "</source>\n";
        return snippet;
    }

    public staticString getDataModel() {
        return null;
    }
}
