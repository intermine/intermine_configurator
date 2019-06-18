package io.swagger.api;

import io.swagger.model.DataTool;
import io.swagger.model.MineConfig;
import io.swagger.model.MineDescriptor;
import io.swagger.model.SupplementaryDataSource;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.intermine.configurator.MineConfigManager;
import org.intermine.configurator.ToolManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-18T09:54:09.498Z[GMT]")
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
        boolean success = MineConfigManager.removeConfig(mineId, userId);
        if (!success) {
            return new ResponseEntity("Mine Config for that user and mine ID not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<MineConfig> getMineConfig(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(key);
        if (mineConfig == null) {
            return new ResponseEntity("Mine Config not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<MineConfig>(mineConfig, HttpStatus.OK);
    }

    public ResponseEntity<MineDescriptor> getMineDescriptors(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(key);
        if (mineConfig == null) {
            return new ResponseEntity("Mine Config not found", HttpStatus.BAD_REQUEST);
        }
        MineDescriptor mineDescriptor = mineConfig.getMineDescriptor();
        return new ResponseEntity<MineDescriptor>(mineDescriptor, HttpStatus.OK);
    }

    public ResponseEntity<List<SupplementaryDataSource>> getMineSupplementaryDataSources(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(key);
        if (mineConfig == null) {
            return new ResponseEntity("Mine Config not found", HttpStatus.BAD_REQUEST);
        }
        List<SupplementaryDataSource> dataSources = mineConfig.getSupplementaryDataSources();
        return new ResponseEntity<List<SupplementaryDataSource>>(dataSources, HttpStatus.OK);
    }

    public ResponseEntity<UUID> getNewMine(@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        UUID mineId = java.util.UUID.randomUUID();
        MineConfig mineConfig = new MineConfig();
        MultiKey key = new MultiKey(mineId, userId);
        MineConfigManager.MINE_CONFIGS.put(key, mineConfig);
        return new ResponseEntity<UUID>(mineId, HttpStatus.OK);
    }

    public ResponseEntity<List<DataTool>> mineDataToolsGet(@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(key);
        if (mineConfig == null) {
            return new ResponseEntity("Mine Config not found", HttpStatus.BAD_REQUEST);
        }
        List<DataTool> dataTools = mineConfig.getDataTools();
        return new ResponseEntity<List<DataTool>>(dataTools, HttpStatus.OK);
    }

    public ResponseEntity<Void> mineDataToolsPost(@ApiParam(value = "Tool to be used with mine" ,required=true )  @Valid @RequestBody List<Object> body,@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        MultiKey key = new MultiKey(mineId, userId);
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(key);
        if (mineConfig == null) {
            return new ResponseEntity("Mine Config not found", HttpStatus.BAD_REQUEST);
        }
        List<Object> dataTools = body;
        ToolManager.addTools(key, dataTools);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> setMineDescriptors(@ApiParam(value = "Descriptors to set for Mine" ,required=true )  @Valid @RequestBody MineDescriptor body,@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
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

        MineConfig mineConfig = new MineConfig();
        mineConfig.setMineDescriptor(mineDescriptor);

        MultiKey key = new MultiKey(mineId, userId);

        MineConfigManager.MINE_CONFIGS.put(key, mineConfig);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> setSupplementaryDataSources(@ApiParam(value = "Supplementary sources to be used with mine" ,required=true )  @Valid @RequestBody List<Object> body,@NotNull @ApiParam(value = "ID of mine config to retrieve", required = true) @Valid @RequestParam(value = "mineId", required = true) UUID mineId,@NotNull @ApiParam(value = "ID of user who owns this mine", required = true) @Valid @RequestParam(value = "userId", required = true) UUID userId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
