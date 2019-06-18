package org.intermine.configurator;

import io.swagger.model.MineConfig;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.keyvalue.MultiKey;

public class MineConfigManager {

    // temporary class. this is all going in mongo db
    public static Map<MultiKey, MineConfig> MINE_CONFIGS = new HashMap<MultiKey, MineConfig>();
}
