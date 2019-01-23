package org.intermine.creator;

import io.swagger.model.MineConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MineConfigManager {

    // temporary class. this is all going in mongo db
    public static Map<UUID, MineConfig> MINE_CONFIGS = new HashMap<UUID, MineConfig>();
}
