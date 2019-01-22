package io.swagger.api;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesResponseInner;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
@Controller
public class FileApiController implements FileApi {

    private static final Logger log = LoggerFactory.getLogger(FileApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FileApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<DataFileProperties> detectFileProperties(@ApiParam(value = "File or file snippet that needs to be identified." ,required=true )  @Valid @RequestBody DataFile body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<DataFileProperties>(HttpStatus.NOT_IMPLEMENTED);
    }

    // public ResponseEntity<DataFileProperties> detectFileProperties(@ApiParam(value = "") @RequestParam(value="name", required=false)  String name,@ApiParam(value = "") @RequestParam(value="fileContents", required=false)  String fileContents,@ApiParam(value = "") @RequestParam(value="organism", required=false)  Object organism) {
    //     String accept = request.getHeader("Accept");
    //     return new ResponseEntity<DataFileProperties>(HttpStatus.NOT_IMPLEMENTED);
    // }

    public ResponseEntity<Void> fileDeletePost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody String body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> fileSavePost(@ApiParam(value = "File or file snippet that needs to be identified." ,required=true )  @Valid @RequestBody DataFile body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> saveFileProperties(@ApiParam(value = "File or file snippet that needs to be identified." ,required=true )  @Valid @RequestBody List<DataFilePropertiesResponseInner> body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}