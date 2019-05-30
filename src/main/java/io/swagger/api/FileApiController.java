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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-30T07:36:59.085Z[GMT]")
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

    // public ResponseEntity<DataFileProperties> detectFileProperties(@ApiParam(value = "File that needs to be identified." ,required=true )  @Valid @RequestBody DataFile body) {
    //     String accept = request.getHeader("Accept");
    //     return new ResponseEntity<DataFileProperties>(HttpStatus.NOT_IMPLEMENTED);
    // }

    public ResponseEntity<DataFileProperties> detectFileProperties(@ApiParam(value = "", required=true) @RequestParam(value="name", required=true)  String name,@ApiParam(value = "", required=true) @RequestParam(value="fileLocation", required=true)  String fileLocation,@ApiParam(value = "", required=true, allowableValues="fasta, gff, tab, csv") @RequestParam(value="fileFormat", required=true)  String fileFormat,@ApiParam(value = "", required=true) @RequestParam(value="organism", required=true)  Object organism) {
        String accept = request.getHeader("Accept");
        String fileContents = body.getFileContents();
        String fileFormat = body.getFileFormat().toString();

        BioValidationResults validationResults = BioValidator.Validate(fileFormat, fileContents, false);
        // invalid file
        if (!validationResults.isValid()) {
            return new ResponseEntity(validationResults.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
        DataFileProperties fileProps = new DataFileProperties();
        fileProps.setFileFormat(body.getFileFormat().toString());
        fileProps.setName(body.getName());
        fileProps.setRowCount(validationResults.getRowCount());
        fileProps.setOrganism(body.getOrganism());
        //fileProps.setFilePreview("nothing yet\nnot implemented");
        return new ResponseEntity<DataFileProperties>(fileProps, HttpStatus.OK);
    }

    public ResponseEntity<Void> saveFileProperties(@ApiParam(value = "File that needs to be identified." ,required=true )  @Valid @RequestBody List<DataFilePropertiesResponseInner> body,@ApiParam(value = "ID of mine to fetch",required=true) @PathVariable("mineId") String mineId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
