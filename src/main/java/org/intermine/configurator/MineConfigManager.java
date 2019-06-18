package org.intermine.configurator;

import io.swagger.model.MineConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MineConfigManager {

    // temporary class. this is all going in mongo db
    public static Map<MultiKey, MineConfig> MINE_CONFIGS = new HashMap<MultiKey, MineConfig>();

    /**
     * Destroy the associated config for mine
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public static boolean removeConfig(UUID mineId, UUID userId) {
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MINE_CONFIGS.get(key);
        if (mineConfig == null) {
            return false;
        }
        MINE_CONFIGS.remove(key);
        return true;
    }

}
