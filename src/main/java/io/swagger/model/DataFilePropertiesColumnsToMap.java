package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesModelPropertyToMapTo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePropertiesColumnsToMap
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-23T15:20:22.668Z[GMT]")
public class DataFilePropertiesColumnsToMap   {
  @JsonProperty("fileColumnName")
  private String fileColumnName = null;

  @JsonProperty("fileColumnExample")
  private String fileColumnExample = null;

  @JsonProperty("modelClassToMapTo")
  private String modelClassToMapTo = null;

  @JsonProperty("modelPropertyToMapTo")
  @Valid
  private List<DataFilePropertiesModelPropertyToMapTo> modelPropertyToMapTo = null;

  @JsonProperty("defaultMapping")
  private String defaultMapping = null;

  public DataFilePropertiesColumnsToMap fileColumnName(String fileColumnName) {
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

  public DataFilePropertiesColumnsToMap fileColumnExample(String fileColumnExample) {
    this.fileColumnExample = fileColumnExample;
    return this;
  }

  /**
   * Get fileColumnExample
   * @return fileColumnExample
  **/
  @ApiModelProperty(example = "100287102", value = "")

  public String getFileColumnExample() {
    return fileColumnExample;
  }

  public void setFileColumnExample(String fileColumnExample) {
    this.fileColumnExample = fileColumnExample;
  }

  public DataFilePropertiesColumnsToMap modelClassToMapTo(String modelClassToMapTo) {
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

  public DataFilePropertiesColumnsToMap modelPropertyToMapTo(List<DataFilePropertiesModelPropertyToMapTo> modelPropertyToMapTo) {
    this.modelPropertyToMapTo = modelPropertyToMapTo;
    return this;
  }

  public DataFilePropertiesColumnsToMap addModelPropertyToMapToItem(DataFilePropertiesModelPropertyToMapTo modelPropertyToMapToItem) {
    if (this.modelPropertyToMapTo == null) {
      this.modelPropertyToMapTo = new ArrayList<DataFilePropertiesModelPropertyToMapTo>();
    }
    this.modelPropertyToMapTo.add(modelPropertyToMapToItem);
    return this;
  }

  /**
   * Get modelPropertyToMapTo
   * @return modelPropertyToMapTo
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<DataFilePropertiesModelPropertyToMapTo> getModelPropertyToMapTo() {
    return modelPropertyToMapTo;
  }

  public void setModelPropertyToMapTo(List<DataFilePropertiesModelPropertyToMapTo> modelPropertyToMapTo) {
    this.modelPropertyToMapTo = modelPropertyToMapTo;
  }

  public DataFilePropertiesColumnsToMap defaultMapping(String defaultMapping) {
    this.defaultMapping = defaultMapping;
    return this;
  }

  /**
   * Get defaultMapping
   * @return defaultMapping
  **/
  @ApiModelProperty(value = "")

  public String getDefaultMapping() {
    return defaultMapping;
  }

  public void setDefaultMapping(String defaultMapping) {
    this.defaultMapping = defaultMapping;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesColumnsToMap dataFilePropertiesColumnsToMap = (DataFilePropertiesColumnsToMap) o;
    return Objects.equals(this.fileColumnName, dataFilePropertiesColumnsToMap.fileColumnName) &&
        Objects.equals(this.fileColumnExample, dataFilePropertiesColumnsToMap.fileColumnExample) &&
        Objects.equals(this.modelClassToMapTo, dataFilePropertiesColumnsToMap.modelClassToMapTo) &&
        Objects.equals(this.modelPropertyToMapTo, dataFilePropertiesColumnsToMap.modelPropertyToMapTo) &&
        Objects.equals(this.defaultMapping, dataFilePropertiesColumnsToMap.defaultMapping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileColumnName, fileColumnExample, modelClassToMapTo, modelPropertyToMapTo, defaultMapping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesColumnsToMap {\n");
    
    sb.append("    fileColumnName: ").append(toIndentedString(fileColumnName)).append("\n");
    sb.append("    fileColumnExample: ").append(toIndentedString(fileColumnExample)).append("\n");
    sb.append("    modelClassToMapTo: ").append(toIndentedString(modelClassToMapTo)).append("\n");
    sb.append("    modelPropertyToMapTo: ").append(toIndentedString(modelPropertyToMapTo)).append("\n");
    sb.append("    defaultMapping: ").append(toIndentedString(defaultMapping)).append("\n");
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
