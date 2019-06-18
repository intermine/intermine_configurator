package io.swagger.api;

import io.swagger.model.DataTool;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.intermine.configurator.ToolManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-18T09:54:09.498Z[GMT]")
@Controller
public class DataToolsApiController implements DataToolsApi {

    private static final Logger log = LoggerFactory.getLogger(DataToolsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DataToolsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<DataTool>> dataToolsGet() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<DataTool>>(ToolManager.getAllTools(), HttpStatus.OK);
    }

}
