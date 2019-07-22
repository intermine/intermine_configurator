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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import io.swagger.model.MineDescriptor;
import org.intermine.configurator.config.buildconfig.AbstractSource;
import org.intermine.configurator.config.buildconfig.SourceFactory;
import org.springframework.util.StringUtils;

/**
 * Handles all the interaction with the database and user-config previously created.
 */
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

    /**
     * Adds a record to the database with this mineId and userId.
     *
     * Does not check if that mineId+userId is already present, so will overwrite current entries.
     *
     * @param repository link to database
     * @param mineId UUID for this mine
     * @param userId UUID for this user
     */
    public void addMineConfig(MineUserConfigRepository repository, UUID mineId, UUID userId) {
        MineUserConfig mineUserConfig = new MineUserConfig();
        mineUserConfig.setMineId(mineId);
        mineUserConfig.setUserId(userId);
        repository.save(mineUserConfig);
    }

    /**
     * Returns mine (user) config for given IDs. Returns NULL if not found in the database.
     *
     * @param repository link to database
     * @param mineId UUID for this mine
     * @return config associated with this mine
     */
    public MineUserConfig getMineConfig(MineUserConfigRepository repository, UUID mineId) {
        Optional<MineUserConfig> optionalMineUserConfig = repository.findById(mineId.toString());
        if (!optionalMineUserConfig.isPresent()) {
            return null;
        }
        return optionalMineUserConfig.get();
    }

    /**
     * Destroy the associated config for mine
     *
     * @param repository link to database
     * @param mineId id of mine
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public boolean removeConfig(MineUserConfigRepository repository, UUID mineId) {
        repository.deleteById(mineId.toString());
        return true;
    }

    /**
     * Get the descriptors, e.g. mine name, for the mine with the ID provided.
     *
     * Might be NULL if it doesn't exist.
     *
     * @param repository link to database
     * @param mineId id of mine
     * @return descriptors associated with this mine
     */
    public MineDescriptor getMineDescriptor(MineUserConfigRepository repository, UUID mineId) {
        MineUserConfig config = getMineConfig(repository, mineId);
        return config.getMineDescriptor();
    }

    /**
     * Sets the descriptors, e.g. mine name, for the mine with the ID provided.
     *
     * Overwrites any previously set mine descriptors.
     *
     * @param repository link to database
     * @param mineId id of mine
     */
    public void setMineDescriptor(MineUserConfigRepository repository, UUID mineId, MineDescriptor descriptor) {
        MineUserConfig config = getMineConfig(repository, mineId);
        config.setMineDescriptor(descriptor);
        repository.save(config);
    }

    /**
     * Retrieve the supplementary sources assigned to this mine
     *
     * @param repository link to database
     * @param mineId id of mine
     * @return list of supp sources for this mine
     */
    public List<SupplementaryDataSource> getSupplementaryDataSources(MineUserConfigRepository repository, UUID mineId) {
        MineUserConfig config = getMineConfig(repository, mineId);
        return config.getSupplementaryDataSources();
    }

    /**
     * Sets the supplementary sources to be loaded into this mine.
     *
     * Overwrites any previously set values.
     *
     * @param repository link to database
     * @param mineId id of mine
     * @param sourceNames list of sources to add
     */
    public void setSupplementaryDataSources(MineUserConfigRepository repository, UUID mineId, List<String> sourceNames) {
        MineUserConfig config = getMineConfig(repository, mineId);
        List<SupplementaryDataSource> supplementaryDataSources = new ArrayList<>();
        for (String sourceName : sourceNames) {
            SupplementaryDataSource supplementaryDataSource = new SupplementaryDataSource();
            supplementaryDataSource.setLabel(sourceName);
            supplementaryDataSources.add(supplementaryDataSource);
        }
        config.setSupplementaryDataSources(supplementaryDataSources);
        repository.save(config);
    }

    /**
     * Retrieve the tools assigned to this mine
     *
     * @param repository link to database
     * @param mineId id of mine
     * @return list of tools for this mine
     */
    public List<DataTool> getTools(MineUserConfigRepository repository, UUID mineId) {
        MineUserConfig config = getMineConfig(repository, mineId);
        return config.getDataTools();
    }

    /**
     * Set the tools assigned to this mine.
     *
     * @param repository link to database
     * @param mineId id of mine
     * @param toolIds list of tools for this mine
     */
    public void setTools(MineUserConfigRepository repository, UUID mineId, List<String> toolIds) {
        MineUserConfig config = getMineConfig(repository, mineId);
        List<DataTool> tools = ToolManager.getDataTools(toolIds);
        config.setDataTools(tools);
        repository.save(config);
    }

    /**
     * Destroy the associated config for file
     *
     * @param repository link to database
     * @param mineId id of mine
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public boolean removeFileProperties(MineUserConfigRepository repository, UUID mineId, UUID fileId) {
        if (fileId == null) {
            return false;
        }
        MineUserConfig config = getMineConfig(repository, mineId);
        List<DataFileProperties> dataFileProperties = config.getDataFiles();
        if (dataFileProperties == null || dataFileProperties.isEmpty()) {
            return false;
        }
        DataFileProperties propertyToDelete = getFileProperties(repository, mineId, fileId);
        if (propertyToDelete != null) {
            dataFileProperties.remove(propertyToDelete);
            config.setDataFiles(dataFileProperties);
            repository.save(config);
            return true;
        }
        return false;
    }

    /**
     * Add the associated file config
     *
     * @param repository link to database
     * @param mineId id of mine
     * @param fileId id of file
     * @param dataFileProperties config associate with file
     * @return TRUE if operation successful, FALSE is mineId/userId not found
     */
    public boolean addFileProperties(MineUserConfigRepository repository, UUID mineId, UUID fileId,
        DataFileProperties dataFileProperties) {
        // delete if there
        removeFileProperties(repository, mineId, fileId);

        // add entry
        MineUserConfig config = getMineConfig(repository, mineId);
        config.addDataFilesItem(dataFileProperties);
        repository.save(config);
        return true;
    }

    /**
     * Get the associated file config
     *
     * @param repository link to database
     * @param mineId id of mine
     * @param fileId id of file
     * @return associated file config
     */
    public DataFileProperties getFileProperties(MineUserConfigRepository repository, UUID mineId, UUID fileId) {
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

    /**
     * Get the associated file config
     *
     * @param repository link to database
     * @param mineId id of mine
     * @param dataFileProperties id of file
     * @param userResponses list of answer options the user selected via the wizard
     */
    public void setSelectedAnswers(MineUserConfigRepository repository, UUID mineId, DataFileProperties dataFileProperties,
        List<DataFilePropertiesResponseAnswers> userResponses) {
        MineUserConfig config = getMineConfig(repository, mineId);
        Map<String, String> selectedAnswers = new HashMap<>();
        for (DataFilePropertiesResponseAnswers answer : userResponses) {
            selectedAnswers.put(answer.getQuestionId(), answer.getAnswerId());
        }
        updateUserSelectionInConfig(repository, config, dataFileProperties, selectedAnswers);
    }

    // update the config
    private void updateUserSelectionInConfig(MineUserConfigRepository repository, MineUserConfig config,
        DataFileProperties dataFileProperties, Map<String, String> selectedAnswers) {
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
        repository.save(config);
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
