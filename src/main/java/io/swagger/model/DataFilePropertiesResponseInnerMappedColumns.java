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
 * DataFilePropertiesResponseInnerMappedColumns
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-23T15:20:22.668Z[GMT]")
public class DataFilePropertiesResponseInnerMappedColumns   {
  @JsonProperty("fileColumnName")
  private String fileColumnName = null;

  @JsonProperty("modelClassToMapTo")
  private String modelClassToMapTo = null;

  @JsonProperty("modelPropertyToMapTo")
  private String modelPropertyToMapTo = null;

  public DataFilePropertiesResponseInnerMappedColumns fileColumnName(String fileColumnName) {
    this.fileColumnName = fileColumnName;
    return this;
  }

  /**
   * Get fileColumnName
   * @return fileColumnName
  **/
  @ApiModelProperty(example = "GeneID", value = "")

  public String getFileColumnName() {
    return fileColumnName;
  }

  public void setFileColumnName(String fileColumnName) {
    this.fileColumnName = fileColumnName;
  }

  public DataFilePropertiesResponseInnerMappedColumns modelClassToMapTo(String modelClassToMapTo) {
    this.modelClassToMapTo = modelClassToMapTo;
    return this;
  }

  /**
   * Get modelClassToMapTo
   * @return modelClassToMapTo
  **/
  @ApiModelProperty(example = "Gene", value = "")

  public String getModelClassToMapTo() {
    return modelClassToMapTo;
  }

  public void setModelClassToMapTo(String modelClassToMapTo) {
    this.modelClassToMapTo = modelClassToMapTo;
  }

  public DataFilePropertiesResponseInnerMappedColumns modelPropertyToMapTo(String modelPropertyToMapTo) {
    this.modelPropertyToMapTo = modelPropertyToMapTo;
    return this;
  }

  /**
   * Get modelPropertyToMapTo
   * @return modelPropertyToMapTo
  **/
  @ApiModelProperty(example = "primaryIdentifier", value = "")

  public String getModelPropertyToMapTo() {
    return modelPropertyToMapTo;
  }

  public void setModelPropertyToMapTo(String modelPropertyToMapTo) {
    this.modelPropertyToMapTo = modelPropertyToMapTo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesResponseInnerMappedColumns dataFilePropertiesResponseInnerMappedColumns = (DataFilePropertiesResponseInnerMappedColumns) o;
    return Objects.equals(this.fileColumnName, dataFilePropertiesResponseInnerMappedColumns.fileColumnName) &&
        Objects.equals(this.modelClassToMapTo, dataFilePropertiesResponseInnerMappedColumns.modelClassToMapTo) &&
        Objects.equals(this.modelPropertyToMapTo, dataFilePropertiesResponseInnerMappedColumns.modelPropertyToMapTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileColumnName, modelClassToMapTo, modelPropertyToMapTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesResponseInnerMappedColumns {\n");
    
    sb.append("    fileColumnName: ").append(toIndentedString(fileColumnName)).append("\n");
    sb.append("    modelClassToMapTo: ").append(toIndentedString(modelClassToMapTo)).append("\n");
    sb.append("    modelPropertyToMapTo: ").append(toIndentedString(modelPropertyToMapTo)).append("\n");
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
