package io.swagger.api;

import io.swagger.model.DataFile;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataFilePropertiesResponseInner;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.Organism;
import org.intermine.creator.BioValidationResults;
import org.intermine.creator.BioValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
@Controller
public class FileApiController implements FileApi {

    private static final Logger LOG = LoggerFactory.getLogger(FileApiController.class);
    private static final String FASTA = "fasta";
    private static final String GFF = "gff";
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private static final Map<String, String> FILE_EXTENSTIONS = new HashMap<String, String>();

    @org.springframework.beans.factory.annotation.Autowired
    public FileApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<DataFileProperties> detectFileProperties(@ApiParam(value = "File or file snippet that needs to be identified." ,required=true )  @Valid @RequestBody DataFile body) {
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

//    @ExceptionHandler(ApiException.class)
//    public ResponseEntity<DataFileProperties> detectFileProperties(@ApiParam(value = "") @RequestParam(value="name", required=true)  String name,@ApiParam(value = "") @RequestParam(value="fileContents", required=true)  String fileContents,@ApiParam(value = "", allowableValues="fasta, gff, tab, csv") @RequestParam(value="fileFormat", required=true)  String fileFormat,@ApiParam(value = "") @RequestParam(value="organism", required=true)  Object organism) {
//        String accept = request.getHeader("Accept");
//        BioValidationResults validationResults = BioValidator.Validate(fileFormat, fileContents, false);
//        if (!validationResults.isValid()) {
//            return new ResponseEntity(validationResults.getErrorMessage(), HttpStatus.BAD_REQUEST);
//        }
//        DataFileProperties fileProps = new DataFileProperties();
//        fileProps.setFileFormat(fileFormat);
//        fileProps.setName(name);
//        fileProps.setRowCount(validationResults.getRowCount());
//        fileProps.setOrganism(organism);
//        //fileProps.setFilePreview("nothing yet\nnot implemented");
//        return new ResponseEntity<DataFileProperties>(fileProps, HttpStatus.OK);
//    }

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
