package org.intermine.configurator;

import io.swagger.model.DataTool;
import io.swagger.model.MineConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import io.swagger.model.MineDescriptor;
import io.swagger.model.SupplementaryDataSource;
import org.apache.commons.collections4.keyvalue.MultiKey;

public class MineConfigManager {

    // temporary class. this is all going in mongo db
    private static Map<MultiKey, MineConfig> MINE_CONFIGS = new HashMap<MultiKey, MineConfig>();

    public static boolean isValid(UUID mineId, UUID userId) {
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MINE_CONFIGS.get(key);
        if (mineConfig != null) {
            return true;
        }
        return false;
    }

    public static void addConfig(UUID mineId, UUID userId) {
        MineConfig mineConfig = new MineConfig();
        MultiKey multiKey = new MultiKey(mineId, userId);
        MINE_CONFIGS.put(multiKey, mineConfig);
    }

    public static MineConfig getConfig(UUID mineId, UUID userId) {
        MultiKey key = new MultiKey(mineId, userId);
        //TODO generate model and project XML
        return MINE_CONFIGS.get(key);
    }

    /**
     * Destroy the associated config for mine
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public static boolean removeConfig(UUID mineId, UUID userId) {
        if (!isValid(mineId, userId)) {
            return false;
        }
        MultiKey key = new MultiKey(mineId, userId);
        MINE_CONFIGS.remove(key);
        return true;
    }

    public static MineDescriptor getMineDescriptor(UUID mineId, UUID userId) {
        MultiKey key = new MultiKey(mineId, userId);
        return MINE_CONFIGS.get(key).getMineDescriptor();
    }

    public static void setMineDescriptor(UUID mineId, UUID userId, MineDescriptor descriptor) {
        if (!isValid(mineId, userId)) {
            return;
        }
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig config = MINE_CONFIGS.get(key);
        config.setMineDescriptor(descriptor);
    }

    /**
     * Retrieve the sources assigned to this mine
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return list of supp sources for this mine
     */
    public static List<SupplementaryDataSource> getSupplementaryDataSources(UUID mineId, UUID userId) {
        if (!isValid(mineId, userId)) {
            return null;
        }
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MINE_CONFIGS.get(key);
        return mineConfig.getSupplementaryDataSources();
    }

    public static void setSupplementaryDataSources(UUID mineId, UUID userId, List<Object> sources) {
        if (!isValid(mineId, userId)) {
            return;
        }

        List<SupplementaryDataSource> dataSources = SourceManager.getValidSources(sources);

        MultiKey key = new MultiKey(mineId, userId);
        MineConfig config = MINE_CONFIGS.get(key);
        config.setSupplementaryDataSources(dataSources);
    }

    /**
     * Retrieve the tools assigned to this mine
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return list of tools for this mine
     */
    public static List<DataTool> getTools(UUID mineId, UUID userId) {
        if (!isValid(mineId, userId)) {
            return null;
        }
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MINE_CONFIGS.get(key);
        return mineConfig.getDataTools();
    }

    /**
     * set the tools assigned to this mine
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @param toolIds list of tools for this mine
     */
    public static void setTools(UUID mineId, UUID userId, List<String> toolIds) {
        if (!isValid(mineId, userId)) {
            return;
        }
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MINE_CONFIGS.get(key);
        List<DataTool> tools = ToolManager.getTools(toolIds);
        mineConfig.setDataTools(tools);
    }

}
