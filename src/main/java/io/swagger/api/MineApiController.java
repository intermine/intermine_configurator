package io.swagger.api;

import io.swagger.model.DataTool;
import io.swagger.model.DataToolResponse;
import io.swagger.model.MineConfig;
import io.swagger.model.MineDescriptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.intermine.configurator.MineConfigManager;
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
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-30T09:11:48.356Z[GMT]")
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

    public ResponseEntity<Void> deleteConfig(@ApiParam(value = "ID of mine config to delete",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(mineId);
        if (mineConfig == null) {
            return new ResponseEntity("Mine Id not found", HttpStatus.BAD_REQUEST);
        }
        MineConfigManager.MINE_CONFIGS.remove(mineId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<MineConfig> getMineConfig(@ApiParam(value = "ID of mine to fetch",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(mineId);
        if (mineConfig == null) {
            return new ResponseEntity("Mine Config not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<MineConfig>(mineConfig, HttpStatus.OK);
    }

    public ResponseEntity<MineDescriptor> getMineDescriptors(@ApiParam(value = "ID of mine to fetch",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(mineId);
        if (mineConfig == null) {
            return new ResponseEntity("Mine Config not found", HttpStatus.BAD_REQUEST);
        }
        MineDescriptor mineDescriptor = mineConfig.getMineDescriptor();
        return new ResponseEntity<MineDescriptor>(mineDescriptor, HttpStatus.OK);
    }

    public ResponseEntity<String> getNewMine() {
        String accept = request.getHeader("Accept");
        String mineId = java.util.UUID.randomUUID().toString();
        MineConfig mineConfig = new MineConfig();
        MineConfigManager.MINE_CONFIGS.put(mineId.toString(), mineConfig);
        return new ResponseEntity<String>(mineId, HttpStatus.OK);
    }

    public ResponseEntity<List<DataTool>> mineDataToolsMineIdGet(@ApiParam(value = "ID of mineconfig to fetch tools for",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(mineId);
        if (mineConfig == null) {
            return new ResponseEntity("Mine Config not found", HttpStatus.BAD_REQUEST);
        }
        List<DataTool> dataTools = mineConfig.getDataTools();
        return new ResponseEntity<List<DataTool>>(dataTools, HttpStatus.OK);;
    }

    public ResponseEntity<DataToolResponse> mineDataToolsMineIdPost(@ApiParam(value = "ID of mineconfig to set tools for",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<DataToolResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> setMineDescriptors(@ApiParam(value = "Descriptors to set for Mine" ,required=true )  @Valid @RequestBody MineDescriptor body,@ApiParam(value = "ID of mine to fetch",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");

        String mineName = body.getMineName().toString();
        String privacy = body.getPrivacy().toString();
        MineDescriptor.PrivacyEnum privacyEnum = MineDescriptor.PrivacyEnum.UNLISTED;
        if (MineDescriptor.PrivacyEnum.PUBLIC.equals(privacy)) {
            privacyEnum = MineDescriptor.PrivacyEnum.PUBLIC;
        }
        String licence = body.getLicence().toString();

        MineDescriptor mineDescriptor = new MineDescriptor();
        mineDescriptor.setMineName(mineName);
        mineDescriptor.setPrivacy(privacyEnum);
        mineDescriptor.setLicence(licence);

        MineConfig mineConfig = new MineConfig();
        mineConfig.setMineDescriptor(mineDescriptor);

        MineConfigManager.MINE_CONFIGS.put(mineId, mineConfig);
        return new ResponseEntity<Void>(HttpStatus.OK);
   }
}
