package org.intermine.configurator.source.project;

import io.swagger.model.DataFileProperties;
import org.intermine.configurator.source.project.AbstractSource;
;
import java.util.HashMap;
import java.util.Map;

public class FastaSourceEntry implements AbstractSource {

    Map<String, String> selectedAnswers = new HashMap<>();
    String taxonId, dataType, classAttribute, fileLocation;
    DataFileProperties dataFileProperties;

    public FastaSourceEntry() {
        // constructor
    }

    /**
     * Sets the handler for the data source. Includes all config needed for the wizard.
     */
    public void setDataFileProperties(DataFileProperties dataFileProperties) {
        this.dataFileProperties = dataFileProperties;
    }

    public String getProjectXML() {
        String snippet = " <source name=\"fasta\" type=\"fasta\" >\n"
                + "<property name=\"fasta.taxonId\" value=\"" + taxonId + "\"/>\n"
                + "<property name=\"fasta.dataSetTitle\" value=\"FASTA data set\"/>\n"
                + "<property name=\"fasta.dataSourceName\" value=\"InterMine import\"/>\n"
                // "org.intermine.model.bio.Gene"
                + "<property name=\"fasta.className\" value=\"" + dataType + "\"/>\n"
                + "<property name=\"fasta.classAttribute\" value=\"" + classAttribute + "\"/>\n"
                + "<property name=\"\"src.data.dir\" location=\"" + fileLocation + "\"/>\n"
                + "</source>\n";
        return snippet;
    }

    public String getDataModel() {
        return null;
    }


}
