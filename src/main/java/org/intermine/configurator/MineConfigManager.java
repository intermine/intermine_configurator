package org.intermine.configurator;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesAnswerOption;
import io.swagger.model.DataFilePropertiesQuestion;
import io.swagger.model.DataFilePropertiesResponseAnswers;
import io.swagger.model.DataTool;
import io.swagger.model.MineBuildConfig;
import io.swagger.model.MineUserConfig;
import io.swagger.model.SupplementaryDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.swagger.model.MineDescriptor;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.intermine.configurator.source.project.AbstractSource;
import org.intermine.configurator.source.project.SourceFactory;
import org.springframework.util.StringUtils;


public class MineConfigManager {

    // temporary class. this is all going in mongo db
    private static Map<MultiKey, MineUserConfig> MINE_CONFIGS = new HashMap<>();

    public static boolean isValid(UUID mineId, UUID userId) {
        MultiKey key = new MultiKey(mineId, userId);
        if (MINE_CONFIGS.get(key) != null) {
            return true;
        }
        return false;
    }

    public static void addMineConfig(UUID mineId, UUID userId) {
        MineUserConfig mineUserConfig = new MineUserConfig();
        MultiKey multiKey = new MultiKey(mineId, userId);
        MINE_CONFIGS.put(multiKey, mineUserConfig);
    }

    public static MineUserConfig getMineConfig(UUID mineId, UUID userId) {
        if (!isValid(mineId, userId)) {
            return null;
        }
        MultiKey key = new MultiKey(mineId, userId);
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
        if (!isValid(mineId, userId)) {
            return null;
        }
        MultiKey key = new MultiKey(mineId, userId);
        MineUserConfig config = MINE_CONFIGS.get(key);
        return config.getMineDescriptor();
    }

    public static void setMineDescriptor(UUID mineId, UUID userId, MineDescriptor descriptor) {
        if (!isValid(mineId, userId)) {
            return;
        }
        MultiKey key = new MultiKey(mineId, userId);
        MineUserConfig config = MINE_CONFIGS.get(key);
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
        MineUserConfig config = MINE_CONFIGS.get(key);
        return config.getSupplementaryDataSources();
    }

    public static void setSupplementaryDataSources(UUID mineId, UUID userId, List<SupplementaryDataSource> sources) {
        if (!isValid(mineId, userId)) {
            return;
        }

        MultiKey key = new MultiKey(mineId, userId);
        MineUserConfig config = MINE_CONFIGS.get(key);
        config.setSupplementaryDataSources(sources);
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
        MineUserConfig config = MINE_CONFIGS.get(key);
        return config.getDataTools();
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
        MineUserConfig config = MINE_CONFIGS.get(key);
        List<DataTool> tools = ToolManager.getDataTools(toolIds);
        config.setDataTools(tools);
    }

    /**
     * Destroy the associated config for file
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public static boolean removeFileProperties(UUID mineId, UUID userId, UUID fileId) {
        if (!isValid(mineId, userId) || fileId == null) {
            return false;
        }
        MultiKey key = new MultiKey(mineId, userId);
        MineUserConfig config = MINE_CONFIGS.get(key);
        List<DataFileProperties> dataFileProperties = config.getDataFiles();
        if (dataFileProperties == null || dataFileProperties.isEmpty()) {
            return false;
        }
        DataFileProperties propertyToDelete = getFileProperties(mineId, userId, fileId);
        if (propertyToDelete != null) {
            dataFileProperties.remove(propertyToDelete);
            config.setDataFiles(dataFileProperties);
            return true;
        }
        return false;
    }

    /**
     * Add the associated file config
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public static boolean addFileProperties(UUID mineId, UUID userId, UUID fileId,
        DataFileProperties dataFileProperties) {
        if (!isValid(mineId, userId)) {
            return false;
        }
        MultiKey key = new MultiKey(mineId, userId);

        // delete if there
        removeFileProperties(mineId, userId, fileId);

        // add entry
        MineUserConfig config = MINE_CONFIGS.get(key);
        config.addDataFilesItem(dataFileProperties);
        return true;
    }

    /**
     * get the associated file config
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public static DataFileProperties getFileProperties(UUID mineId, UUID userId, UUID fileId) {
        if (!isValid(mineId, userId)) {
            return null;
        }
        MultiKey key = new MultiKey(mineId, userId);

        MineUserConfig config = MINE_CONFIGS.get(key);
        List<DataFileProperties> dataFileProperties = config.getDataFiles();

        if (dataFileProperties == null || dataFileProperties.isEmpty()) {
            return null;
        }

        for (DataFileProperties propertyForFile : dataFileProperties) {
            DataFile dataFile = (DataFile) propertyForFile.getDataFile();
            if (fileId.equals(dataFile.getFileId())) {
                return propertyForFile;
            }
        }
        return null;
    }

    public static void setSelectedAnswers(DataFileProperties dataFileProperties,
        List<DataFilePropertiesResponseAnswers> userResponses) {
        Map<String, String> selectedAnswers = new HashMap<>();
        for (DataFilePropertiesResponseAnswers answer : userResponses) {
            selectedAnswers.put(answer.getQuestionId(), answer.getAnswerId());
        }
        updateUserSelectionInConfig(dataFileProperties, selectedAnswers);
    }

    // update the config
    private static void updateUserSelectionInConfig(DataFileProperties dataFileProperties,
        Map<String, String> selectedAnswers) {
        List<DataFilePropertiesQuestion> questions = null;
        questions = dataFileProperties.getQuestions();
        if (questions == null || questions.isEmpty()) {
            return;
        }
        for (DataFilePropertiesQuestion question : questions) {
            String questionId = question.getQuestionId();
            String selectedAnswerId = selectedAnswers.get(questionId);
            if (StringUtils.isEmpty(selectedAnswerId)) {
                continue;
            }
            List<DataFilePropertiesAnswerOption> answerOptions = question.getPossibleAnswers();
            for (DataFilePropertiesAnswerOption answerOption : answerOptions) {
                if (answerOption.getAnswerId().equals(selectedAnswerId)) {
                    answerOption.setIsSelected(true);
                } else {
                    answerOption.setIsSelected(false);
                }
            }
        }
    }

    /**
     * get the associated build config
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public static MineBuildConfig getMineBuildConfig(UUID mineId, UUID userId) {
        if (!isValid(mineId, userId)) {
            return null;
        }
        // config needed for the mine
        MineBuildConfig buildConfig = new MineBuildConfig();

        MultiKey key = new MultiKey(mineId, userId);

        // config generated for the user
        MineUserConfig userConfig = MINE_CONFIGS.get(key);

        buildConfig.setMineDescriptor(userConfig.getMineDescriptor());

        List<DataTool> dataTools = userConfig.getDataTools();
        if (dataTools != null && !dataTools.isEmpty()) {
            for (DataTool tool : dataTools) {
                buildConfig.addDataToolsItem(tool.getToolId());
            }
        }
        if (userConfig.getMineDescriptor() == null) {
            return null;
        }
        String projectXML = generateProjectXML(mineId, userId, userConfig);
        buildConfig.setProjectXML(projectXML);

        return buildConfig;
    }

    private static String generateProjectXML(UUID mineId, UUID userId, MineUserConfig userConfig) {
        StringBuilder projectXML = new StringBuilder();

        String mineName = userConfig.getMineDescriptor().getMineName();

        projectXML.append(getPrefix(mineName));

        List<DataFileProperties> dataFileProperties = userConfig.getDataFiles();
        if (dataFileProperties != null && !dataFileProperties.isEmpty()) {
            for (DataFileProperties propertiesForFile : dataFileProperties) {
                DataFile dataFile = propertiesForFile.getDataFile();
                UUID fileId = dataFile.getFileId();

                String fileLocation = DataFileManager.getFilePath(mineId.toString(), userId.toString(),
                        fileId.toString(), System.getProperty("IM_DATA_DIR"), dataFile.getName());

                DataFile.FileFormatEnum fileFormatEnum = dataFile.getFileFormat();
                AbstractSource dataSource = SourceFactory.getDataSource(fileFormatEnum);
                projectXML.append(dataSource.getProjectXML(propertiesForFile, fileLocation));
            }
        }

        projectXML.append(fileSuffix);

        return projectXML.toString();
    }

    private static String getPrefix(String mineName) {
        return "<project type=\"bio\">\n"
                + "  <property name=\"target.model\" value=\"genomic\"/>\n"
                + "  <property name=\"common.os.prefix\" value=\"common\"/>\n"
                + "  <property name=\"intermine.properties.file\" value=\"" + mineName + ".properties\"/>\n"
                + "  <property name=\"default.intermine.properties.file\" location=\"../default.intermine.integrate.properties\"/>\n"
                + "  <sources>\n";
    }

    private final static String fileSuffix = "  <post-processing>\n"
            + "    <post-process name=\"do-sources\" />\n"
            + "    <post-process name=\"create-attribute-indexes\"/>\n"
            + "    <post-process name=\"summarise-objectstore\"/>\n"
            + "    <post-process name=\"create-autocomplete-index\"/>\n"
            + "    <post-process name=\"create-search-index\"/>\n"
            + "  </post-processing>\n"
            + "</project>";

}
