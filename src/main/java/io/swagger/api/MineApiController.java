package io.swagger.api;

import io.swagger.model.DataTool;
import io.swagger.model.DataToolResponse;
import io.swagger.model.MineConfig;
import io.swagger.model.MineDescriptor;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-30T07:36:59.085Z[GMT]")
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

    public ResponseEntity<MineConfig> getMineConfig(@ApiParam(value = "ID of mine to fetch",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(mineId);
        // TODO when this is requested, we compile all the config
        // what is the life cycle of the config?
        return new ResponseEntity<MineConfig>(mineConfig, HttpStatus.OK);
    }

    public ResponseEntity<MineDescriptor> getMineDescriptors(@ApiParam(value = "ID of mine to fetch",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<MineDescriptor>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> getNewMine() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<DataTool>> mineDataToolsMineIdGet(@ApiParam(value = "ID of mineconfig to fetch tools for",required=true) @PathVariable("mineId") UUID mineId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<DataTool>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DataToolResponse> mineDataToolsMineIdPost(@ApiParam(value = "ID of mineconfig to set tools for",required=true) @PathVariable("mineId") UUID mineId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<DataToolResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> setMineDescriptors(@ApiParam(value = "Descriptors to set for Mine" ,required=true )  @Valid @RequestBody MineDescriptor body,@ApiParam(value = "ID of mine to fetch",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");
        UUID uuid = java.util.UUID.randomUUID();
        MineDescriptor descriptor = body;

        MineConfigManager.MINE_CONFIGS.put(uuid, mineConfig);
        return new ResponseEntity<String>(("{  \"mineId\" : \"" + uuid + "\"}"), HttpStatus.OK);
    }

}
