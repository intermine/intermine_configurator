package org.intermine.configurator.validation;

import io.swagger.model.DataFileDescriptor;
import io.swagger.model.DataFileProperties;
import org.intermine.configurator.validation.ValidationResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ValidationResponseTest {

    @Test
    public void ValidationResponseTest() {
        final String errorMessage = "Invalid file format";
        DataFileProperties dataFileProperties = new DataFileProperties();
        dataFileProperties.addDescriptorsItem(getDescriptor());
        ValidationResponse response = new ValidationResponse(true, errorMessage, dataFileProperties);
        assertEquals(errorMessage, response.errorMessage);
        assertTrue(response.isValid);
        assertEquals(dataFileProperties, response.dataFileProperties);

    }

    private DataFileDescriptor getDescriptor() {
        DataFileDescriptor dataFileDescriptor = new DataFileDescriptor();
        dataFileDescriptor.attributeName("foo");
        dataFileDescriptor.attributeValue("bar");
        return dataFileDescriptor;
    }

}
