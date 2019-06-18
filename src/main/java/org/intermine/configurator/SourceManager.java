package org.intermine.configurator;


import io.swagger.model.SupplementaryDataSource;

import java.util.Arrays;
import java.util.List;


/**
 * manages available sources
 */
public class SourceManager {


    public static List<SupplementaryDataSource> getValidSources(List<Object> dataSources) {
        SupplementaryDataSource source = new SupplementaryDataSource();
        source.setLabel("UniProt");
        return Arrays.asList(source);
    }

}
