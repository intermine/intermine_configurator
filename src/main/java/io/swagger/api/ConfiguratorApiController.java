package io.swagger.api;

import io.swagger.configuration.MineUserConfigRepository;
import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesResponse;
import io.swagger.model.DataFilePropertiesResponseAnswers;
import io.swagger.model.DataTool;
import io.swagger.model.MineBuildConfig;
import io.swagger.model.MineDescriptor;
import io.swagger.model.MineUserConfig;
import io.swagger.model.SupplementaryDataSource;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.intermine.configurator.DataFileManager;
import org.intermine.configurator.MineConfigManager;
import org.intermine.configurator.SupplementaryDataSourceManager;
import org.intermine.configurator.ToolManager;
import org.intermine.configurator.validation.ValidationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-24T07:19:43.280Z[GMT]")
@Controller
public class ConfiguratorApiController implements ConfiguratorApi {

    private static final Logger log = LoggerFactory.getLogger(ConfiguratorApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    MineUserConfigRepository repository;
    MineConfigManager mineConfigManager = new MineConfigManager();

    @org.springframework.beans.factory.annotation.Autowired
    public ConfiguratorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<DataTool>> configuratorDataToolsGet() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<DataTool>>(ToolManager.getAllTools(), HttpStatus.OK);
    }

    public ResponseEntity<List<DataTool>> configuratorMineDataToolsGet(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        List<DataTool> dataTools = mineConfigManager.getTools(repository, mineId);
        return new ResponseEntity<List<DataTool>>(dataTools, HttpStatus.OK);
    }

    public ResponseEntity<Void> configuratorMineDataToolsPost(@ApiParam(value = "Tool to be used with mine" ,required=true )  @Valid @RequestBody List<Object> body,@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        List<String> toolIds = (List<String>)(List<?>) body;
        mineConfigManager.setTools(repository, mineId, toolIds);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteConfig(@NotNull @ApiParam(value = "ID of mine config to delete", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        boolean success = mineConfigManager.removeConfig(repository, mineId);
        if (!success) {
            throw new IllegalArgumentException("User or mine ID not found, deletion failed");
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteMineFileProperties(@NotNull @ApiParam(value = "ID of mine", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId,@NotNull @ApiParam(value = "ID of file", required = true) @Valid @RequestParam(value = "fileId", required = true) UUID fileId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        boolean success = mineConfigManager.removeFileProperties(repository, mineId, fileId);
        if (!success) {
            throw new IllegalArgumentException("File properties not found");
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<DataFileProperties> detectFileProperties(@ApiParam(value = "File that needs to be identified." ,required=true )  @Valid @RequestBody DataFile body,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId,@NotNull @ApiParam(value = "ID of mine", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }

        DataFile dataFile = (DataFile) body;
        UUID fileId = dataFile.getFileId();

        if (System.getenv("IM_DATA_DIR") == null) {
            throw new IllegalArgumentException("Please set ENV VAR '$IM_DATA_DIR'");
        }

        String fileLocation = DataFileManager.getFilePath(userId.toString(), fileId.toString(),
                System.getenv("IM_DATA_DIR"), dataFile.getName());

        ValidationResponse validationResponse = DataFileManager.processDataFile(dataFile, fileLocation);
        if (validationResponse.isValid()) {
            return new ResponseEntity(validationResponse.getDataFileProperties(), HttpStatus.OK);
        } else {
            throw new IllegalArgumentException(validationResponse.getErrorMessage());
        }
    }

    public ResponseEntity<MineBuildConfig> getMineBuildConfig(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        MineBuildConfig config = mineConfigManager.getMineBuildConfig(repository, mineId, userId);
        if (config == null) {
            throw new IllegalArgumentException("Error generating config. Mine name required.");
        }
        return new ResponseEntity<MineBuildConfig>(config, HttpStatus.OK);
    }

    public ResponseEntity<MineDescriptor> getMineDescriptors(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        MineDescriptor mineDescriptor = mineConfigManager.getMineDescriptor(repository, mineId);
        return new ResponseEntity<MineDescriptor>(mineDescriptor, HttpStatus.OK);
    }

    public ResponseEntity<DataFileProperties> getMineFileProperties(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId,@NotNull @ApiParam(value = "ID of file", required = true) @Valid @RequestParam(value = "fileId", required = true) UUID fileId) {
        String accept = request.getHeader("Accept");
        DataFileProperties dataFileProperties = mineConfigManager.getFileProperties(repository, mineId, fileId);
        if (dataFileProperties == null) {
            throw new IllegalArgumentException("File ID not found");
        }
        return new ResponseEntity<DataFileProperties>(dataFileProperties, HttpStatus.OK);
    }

    public ResponseEntity<List<SupplementaryDataSource>> getMineSupplementaryDataSources(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        List<SupplementaryDataSource> dataSources = mineConfigManager.getSupplementaryDataSources(repository, mineId);
        return new ResponseEntity<List<SupplementaryDataSource>>(dataSources, HttpStatus.OK);
    }

    public ResponseEntity<MineUserConfig> getMineUserConfig(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        MineUserConfig config = mineConfigManager.getMineConfig(repository, mineId);
        return new ResponseEntity<MineUserConfig>(config, HttpStatus.OK);
    }

    public ResponseEntity<UUID> getNewMine(@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        UUID mineId = java.util.UUID.randomUUID();
        mineConfigManager.addMineConfig(repository, mineId, userId);
        return new ResponseEntity<UUID>(mineId, HttpStatus.OK);
    }

    public ResponseEntity<List<SupplementaryDataSource>> getSupplementaryDataSources() {
        return new ResponseEntity<List<SupplementaryDataSource>>(SupplementaryDataSourceManager.getAllSupplementarySources(), HttpStatus.OK);
    }

    public ResponseEntity<Void> saveFileProperties(@ApiParam(value = "File that needs to be identified." ,required=true )  @Valid @RequestBody DataFilePropertiesResponse body,@NotNull @ApiParam(value = "ID of mine to fetch", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");

        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }

        if (System.getenv("IM_DATA_DIR") == null) {
            throw new IllegalArgumentException("Please set ENV VAR '$IM_DATA_DIR'");
        }

        DataFile dataFile = (DataFile) body.getDataFile();
        DataFile.FileFormatEnum fileFormatEnum = dataFile.getFileFormat();
        UUID fileId = dataFile.getFileId();

        // TODO refactor this to be overridden in the unit tests.
        String fileLocation = DataFileManager.getFilePath(userId.toString(), fileId.toString(),
                System.getenv("IM_DATA_DIR"), dataFile.getName());

        // set the user config
        ValidationResponse validationResponse = DataFileManager.processDataFile(dataFile, fileLocation);
        if (validationResponse.isValid()) {
            DataFileProperties dataFileProperties = validationResponse.getDataFileProperties();

            // add answers
            List<DataFilePropertiesResponseAnswers> answers = body.getAnswers();
            mineConfigManager.setSelectedAnswers(repository, mineId, dataFileProperties, answers);

            mineConfigManager.addFileProperties(repository, mineId, fileId, dataFileProperties);
            return new ResponseEntity(HttpStatus.OK);
        }
        throw new IllegalArgumentException(validationResponse.getErrorMessage());
    }

    public ResponseEntity<Void> setMineDescriptors(@ApiParam(value = "Descriptors to set for Mine" ,required=true )  @Valid @RequestBody MineDescriptor body,@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        String mineName = "";
        String licence = "";
        // default to be unlisted
        String privacy = MineDescriptor.PrivacyEnum.UNLISTED.toString();

        if (body.getMineName() != null) {
            mineName = body.getMineName().toString();
        }
        if (body.getLicence() != null) {
            licence = body.getLicence().toString();
        }
        if (body.getPrivacy() != null) {
            privacy = body.getPrivacy().toString();
        }

        MineDescriptor.PrivacyEnum privacyEnum = MineDescriptor.PrivacyEnum.UNLISTED;
        if (MineDescriptor.PrivacyEnum.PUBLIC.toString().equals(privacy)) {
            privacyEnum = MineDescriptor.PrivacyEnum.PUBLIC;
        }

        MineDescriptor mineDescriptor = new MineDescriptor();
        mineDescriptor.setMineName(mineName);
        mineDescriptor.setPrivacy(privacyEnum);
        mineDescriptor.setLicence(licence);

        mineConfigManager.setMineDescriptor(repository, mineId, mineDescriptor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> setSupplementaryDataSources(@ApiParam(value = "Supplementary sources to be used with mine" ,required=true )  @Valid @RequestBody List<Object> body,@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!mineConfigManager.isValid(repository, mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        List<String> sources = (List<String>)(List<?>) body;
        mineConfigManager.setSupplementaryDataSources(repository, mineId, sources);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
