package io.swagger.api;

import org.intermine.creator.MineConfigManager;
import io.swagger.model.DataTool;
import io.swagger.model.DataToolResponse;
import io.swagger.model.MineConfig;

import java.util.Date;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
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

    public ResponseEntity<MineConfig> getMineConfig(@ApiParam(value = "ID of mineconfig to fetch",required=true) @PathVariable("mineId") UUID mineId) {
        String accept = request.getHeader("Accept");
        MineConfig mineConfig = MineConfigManager.MINE_CONFIGS.get(mineId);
        return new ResponseEntity<MineConfig>(mineConfig, HttpStatus.OK);
    }

    public ResponseEntity<DataToolResponse> mineDataToolMineIdPost(@ApiParam(value = "ID of mineconfig to set tools for",required=true) @PathVariable("mineId") UUID mineId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<DataToolResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<DataTool>> mineDataToolsMineIdGet(@ApiParam(value = "ID of mineconfig to fetch tools for",required=true) @PathVariable("mineId") UUID mineId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<DataTool>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> setMineConfig(@ApiParam(value = "Config to set for Mine") @Valid @RequestBody MineConfig body) {
        String accept = request.getHeader("Accept");
        UUID uuid = java.util.UUID.randomUUID();
        MineConfig mineConfig = body;
        if (body == null) {
            mineConfig = new MineConfig();
        }

        Date d = new Date();
        mineConfig.setMineName("Temp mine created " + d.toString());
        MineConfigManager.MINE_CONFIGS.put(uuid, mineConfig);
        return new ResponseEntity<String>(("{  \"mineId\" : \"" + uuid + "\"}"), HttpStatus.OK);
    }

}
