package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Array of items describing the file, e.g. row count or sequence type
 */
@ApiModel(description = "Array of items describing the file, e.g. row count or sequence type")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-25T11:51:24.013Z[GMT]")
public class DataFileDescriptor   {
  @JsonProperty("attributeName")
  private String attributeName = null;

  @JsonProperty("attributeValue")
  private String attributeValue = null;

  public DataFileDescriptor attributeName(String attributeName) {
    this.attributeName = attributeName;
    return this;
  }

  /**
   * Get attributeName
   * @return attributeName
  **/
  @ApiModelProperty(example = "Number of entities in the file", value = "")

  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public DataFileDescriptor attributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
    return this;
  }

  /**
   * Get attributeValue
   * @return attributeValue
  **/
  @ApiModelProperty(example = "37", value = "")

  public String getAttributeValue() {
    return attributeValue;
  }

  public void setAttributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFileDescriptor dataFileDescriptor = (DataFileDescriptor) o;
    return Objects.equals(this.attributeName, dataFileDescriptor.attributeName) &&
        Objects.equals(this.attributeValue, dataFileDescriptor.attributeValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeName, attributeValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFileDescriptor {\n");
    
    sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
    sb.append("    attributeValue: ").append(toIndentedString(attributeValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
