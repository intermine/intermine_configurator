package io.swagger.api;

import io.swagger.model.SupplementaryDataSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.intermine.configurator.SupplementaryDataSourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-25T11:51:24.013Z[GMT]")
@Controller
public class SupplementaryDataSourcesApiController implements SupplementaryDataSourcesApi {

    private static final Logger log = LoggerFactory.getLogger(SupplementaryDataSourcesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SupplementaryDataSourcesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<SupplementaryDataSource>> getSupplementaryDataSources() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<SupplementaryDataSource>>(SupplementaryDataSourceManager.getAllSupplementarySources(), HttpStatus.OK);
    }

}
