package org.intermine.configurator;


import io.swagger.model.SupplementaryDataSource;

import java.util.ArrayList;
import java.util.List;


/**
 * manages available sources
 */
public class SupplementarySourceManager {

    /**
     * Returns a list of all available supplementary data sources.
     *
     * This list is hardcoded.
     *
     * @return list of all available supplementary data sources.
     */
    public static List<SupplementaryDataSource> getAllSupplementarySources() {
        List<SupplementaryDataSource> sources = new ArrayList<>();

        SupplementaryDataSource source1 = new SupplementaryDataSource();
        source1.setLabel("Entrez Organism Data");
        source1.setDescription("Based on taxon ID, fills in Organism name, species etc");
        source1.setUrl("https://intermine.readthedocs.io/en/latest/database/data-sources/library/organism/");
        sources.add(source1);

        SupplementaryDataSource source2 = new SupplementaryDataSource();
        source2.setLabel("NCBI PubMed Data");
        source2.setDescription("Based on PubMedID, fills in publication title, author, year etc");
        source2.setUrl("https://intermine.readthedocs.io/en/latest/database/data-sources/library/publications/publications/");
        sources.add(source2);

        return sources;
    }
}
