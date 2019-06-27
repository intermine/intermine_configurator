package io.swagger.api;

import io.swagger.model.DataFileProperties;
import io.swagger.model.DataTool;
import io.swagger.model.MineBuildConfig;
import io.swagger.model.MineDescriptor;
import io.swagger.model.MineUserConfig;
import io.swagger.model.SupplementaryDataSource;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.intermine.configurator.MineConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-25T11:51:24.013Z[GMT]")
@Controller
public class MineApiController implements MineApi {

    private static final Logger log = LoggerFactory.getLogger(MineApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MineApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteConfig(@NotNull @ApiParam(value = "ID of mine config to delete", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        boolean success = MineConfigManager.removeConfig(mineId, userId);
        if (!success) {
            throw new IllegalArgumentException("User or mine ID not found, deletion failed");
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteMineFileProperties(@NotNull @ApiParam(value = "ID of mine", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId,@NotNull @ApiParam(value = "ID of file", required = true) @Valid @RequestParam(value = "fileId", required = true) UUID fileId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        boolean success = MineConfigManager.removeFileProperties(mineId, userId, fileId);
        if (!success) {
            throw new IllegalArgumentException("File properties not found");
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<MineBuildConfig> getMineBuildConfig(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        MineBuildConfig config = MineConfigManager.getMineBuildConfig(mineId, userId);
        if (config == null) {
            throw new IllegalArgumentException("Error generating config. Mine name required.");
        }
        return new ResponseEntity<MineBuildConfig>(config, HttpStatus.OK);
    }

    public ResponseEntity<MineDescriptor> getMineDescriptors(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        MineDescriptor mineDescriptor = MineConfigManager.getMineDescriptor(mineId, userId);
        return new ResponseEntity<MineDescriptor>(mineDescriptor, HttpStatus.OK);
    }

    public ResponseEntity<DataFileProperties> getMineFileProperties(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId,@NotNull @ApiParam(value = "ID of file", required = true) @Valid @RequestParam(value = "fileId", required = true) UUID fileId) {
        String accept = request.getHeader("Accept");
        DataFileProperties dataFileProperties = MineConfigManager.getFileProperties(mineId, userId, fileId);
        if (dataFileProperties == null) {
            throw new IllegalArgumentException("File ID not found");
        }
        return new ResponseEntity<DataFileProperties>(dataFileProperties, HttpStatus.OK);
    }

    public ResponseEntity<List<SupplementaryDataSource>> getMineSupplementaryDataSources(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        List<SupplementaryDataSource> dataSources = MineConfigManager.getSupplementaryDataSources(mineId, userId);
        return new ResponseEntity<List<SupplementaryDataSource>>(dataSources, HttpStatus.OK);
    }

    public ResponseEntity<MineUserConfig> getMineUserConfig(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        MineUserConfig config = MineConfigManager.getMineConfig(mineId, userId);
        return new ResponseEntity<MineUserConfig>(config, HttpStatus.OK);
    }

    public ResponseEntity<UUID> getNewMine(@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        UUID mineId = java.util.UUID.randomUUID();
        MineConfigManager.addMineConfig(mineId, userId);
        return new ResponseEntity<UUID>(mineId, HttpStatus.OK);
    }

    public ResponseEntity<List<DataTool>> mineDataToolsGet(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        List<DataTool> dataTools = MineConfigManager.getTools(mineId, userId);
        return new ResponseEntity<List<DataTool>>(dataTools, HttpStatus.OK);
    }

    public ResponseEntity<Void> mineDataToolsPost(@ApiParam(value = "Tool to be used with mine" ,required=true )  @Valid @RequestBody List<Object> body,@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        List<String> toolIds = (List<String>)(List<?>) body;
        MineConfigManager.setTools(mineId, userId, toolIds);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> setMineDescriptors(@ApiParam(value = "Descriptors to set for Mine" ,required=true )  @Valid @RequestBody MineDescriptor body,@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
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

        MineConfigManager.setMineDescriptor(mineId, userId, mineDescriptor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> setSupplementaryDataSources(@ApiParam(value = "Supplementary sources to be used with mine" ,required=true )  @Valid @RequestBody List<Object> body,@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        if (!MineConfigManager.isValid(mineId, userId)) {
            throw new IllegalArgumentException("User or mine ID not found");
        }
        List<SupplementaryDataSource> sources = (List<SupplementaryDataSource>)(List<?>) body;
        MineConfigManager.setSupplementaryDataSources(mineId, userId, sources);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
