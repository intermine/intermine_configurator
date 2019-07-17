package org.intermine.configurator;

import io.swagger.configuration.MineUserConfigRepository;
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
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import io.swagger.model.MineDescriptor;
import org.intermine.configurator.source.project.AbstractSource;
import org.intermine.configurator.source.project.SourceFactory;
import org.springframework.util.StringUtils;

public class MineConfigManager {

    /**
     * checks if this combo of user and mine is in our database
     *
     * @param mineId UUID for user
     * @param userId UUID for mine
     * @return TRUE if valid combo
     */
    public boolean isValid(MineUserConfigRepository repository, UUID mineId, UUID userId) {
        MineUserConfig mineUserConfig = getMineConfig(repository, mineId);
        if (mineUserConfig == null) {
            return false;
        }
        if (mineUserConfig.getUserId() != null && mineUserConfig.getUserId().equals(userId)) {
            return true;
        }
        return false;
    }

    private MineUserConfig getMineConfig(MineUserConfigRepository repository, UUID mineId) {
        Optional<MineUserConfig> optionalMineUserConfig = repository.findById(mineId.toString());
        if (!optionalMineUserConfig.isPresent()) {
            return null;
        }
        return optionalMineUserConfig.get();
    }

    public void addMineConfig(MineUserConfigRepository repository, UUID mineId, UUID userId) {
        MineUserConfig mineUserConfig = new MineUserConfig();
        mineUserConfig.setMineId(mineId);
        mineUserConfig.setUserId(userId);
        repository.save(mineUserConfig);
    }

    public MineUserConfig getMineConfig(MineUserConfigRepository repository, UUID mineId, UUID userId) {
        if (!isValid(repository, mineId, userId)) {
            return null;
        }
        return getMineConfig(repository, mineId);
    }

    /**
     * Destroy the associated config for mine
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public boolean removeConfig(MineUserConfigRepository repository, UUID mineId, UUID userId) {
        if (!isValid(repository, mineId, userId)) {
            return false;
        }
        repository.deleteById(mineId.toString());
        return true;
    }

    public MineDescriptor getMineDescriptor(MineUserConfigRepository repository, UUID mineId, UUID userId) {
        if (!isValid(repository, mineId, userId)) {
            return null;
        }

        MineUserConfig config = getMineConfig(repository, mineId);
        return config.getMineDescriptor();
    }

    public void setMineDescriptor(MineUserConfigRepository repository, UUID mineId, UUID userId, MineDescriptor descriptor) {
        if (!isValid(repository, mineId, userId)) {
            return;
        }
        MineUserConfig config = getMineConfig(repository, mineId);
        config.setMineDescriptor(descriptor);
    }

    /**
     * Retrieve the sources assigned to this mine
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return list of supp sources for this mine
     */
    public List<SupplementaryDataSource> getSupplementaryDataSources(MineUserConfigRepository repository, UUID mineId, UUID userId) {
        if (!isValid(repository, mineId, userId)) {
            return null;
        }
        MineUserConfig config = getMineConfig(repository, mineId);
        return config.getSupplementaryDataSources();
    }

    public void setSupplementaryDataSources(MineUserConfigRepository repository, UUID mineId, UUID userId, List<SupplementaryDataSource> sources) {
        if (!isValid(repository, mineId, userId)) {
            return;
        }
        MineUserConfig config = getMineConfig(repository, mineId);
        config.setSupplementaryDataSources(sources);
    }

    /**
     * Retrieve the tools assigned to this mine
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @return list of tools for this mine
     */
    public List<DataTool> getTools(MineUserConfigRepository repository, UUID mineId, UUID userId) {
        if (!isValid(repository, mineId, userId)) {
            return null;
        }
        MineUserConfig config = getMineConfig(repository, mineId);
        return config.getDataTools();
    }

    /**
     * set the tools assigned to this mine
     *
     * @param mineId id of mine
     * @param userId id of user who owns mine
     * @param toolIds list of tools for this mine
     */
    public void setTools(MineUserConfigRepository repository, UUID mineId, UUID userId, List<String> toolIds) {
        if (!isValid(repository, mineId, userId)) {
            return;
        }
        MineUserConfig config = getMineConfig(repository, mineId);
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
    public boolean removeFileProperties(MineUserConfigRepository repository, UUID mineId, UUID userId, UUID fileId) {
        if (!isValid(repository, mineId, userId) || fileId == null) {
            return false;
        }
        MineUserConfig config = getMineConfig(repository, mineId);
        List<DataFileProperties> dataFileProperties = config.getDataFiles();
        if (dataFileProperties == null || dataFileProperties.isEmpty()) {
            return false;
        }
        DataFileProperties propertyToDelete = getFileProperties(repository, mineId, userId, fileId);
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
    public boolean addFileProperties(MineUserConfigRepository repository, UUID mineId, UUID userId, UUID fileId,
        DataFileProperties dataFileProperties) {
        if (!isValid(repository, mineId, userId)) {
            return false;
        }
        // delete if there
        removeFileProperties(repository, mineId, userId, fileId);

        // add entry
        MineUserConfig config = getMineConfig(repository, mineId);
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
    public DataFileProperties getFileProperties(MineUserConfigRepository repository, UUID mineId, UUID userId, UUID fileId) {
        if (!isValid(repository, mineId, userId)) {
            return null;
        }
        MineUserConfig config = getMineConfig(repository, mineId);
        List<DataFileProperties> dataFileProperties = config.getDataFiles();

        if (dataFileProperties == null || dataFileProperties.isEmpty()) {
            return null;
        }

        for (DataFileProperties propertyForFile : dataFileProperties) {
            DataFile dataFile = propertyForFile.getDataFile();
            if (fileId.equals(dataFile.getFileId())) {
                return propertyForFile;
            }
        }
        return null;
    }

    public void setSelectedAnswers(MineUserConfigRepository repository, DataFileProperties dataFileProperties,
        List<DataFilePropertiesResponseAnswers> userResponses) {
        Map<String, String> selectedAnswers = new HashMap<>();
        for (DataFilePropertiesResponseAnswers answer : userResponses) {
            selectedAnswers.put(answer.getQuestionId(), answer.getAnswerId());
        }
        updateUserSelectionInConfig(repository, dataFileProperties, selectedAnswers);
    }

    // update the config
    private void updateUserSelectionInConfig(MineUserConfigRepository repository, DataFileProperties dataFileProperties,
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
    public MineBuildConfig getMineBuildConfig(MineUserConfigRepository repository, UUID mineId, UUID userId) {
        if (!isValid(repository, mineId, userId)) {
            return null;
        }
        // config needed for the mine
        MineBuildConfig buildConfig = new MineBuildConfig();

        // config generated for the user
        MineUserConfig userConfig = getMineConfig(repository, mineId);

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

    private String generateProjectXML(UUID mineId, UUID userId, MineUserConfig userConfig) {
        StringBuilder projectXML = new StringBuilder();

        String mineName = userConfig.getMineDescriptor().getMineName();

        projectXML.append(getPrefix(mineName));

        List<DataFileProperties> dataFileProperties = userConfig.getDataFiles();
        if (dataFileProperties != null && !dataFileProperties.isEmpty()) {
            for (DataFileProperties propertiesForFile : dataFileProperties) {
                DataFile dataFile = propertiesForFile.getDataFile();
                UUID fileId = dataFile.getFileId();

                String fileLocation = DataFileManager.getFilePath(mineId.toString(), userId.toString(),
                        fileId.toString(), System.getenv("IM_DATA_DIR"), dataFile.getName());

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
