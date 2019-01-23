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
 * DataFilePropertiesModelPropertyToMapTo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-23T15:20:22.668Z[GMT]")
public class DataFilePropertiesModelPropertyToMapTo   {
  @JsonProperty("humanName")
  private String humanName = null;

  @JsonProperty("modelName")
  private String modelName = null;

  public DataFilePropertiesModelPropertyToMapTo humanName(String humanName) {
    this.humanName = humanName;
    return this;
  }

  /**
   * Get humanName
   * @return humanName
  **/
  @ApiModelProperty(value = "")

  public String getHumanName() {
    return humanName;
  }

  public void setHumanName(String humanName) {
    this.humanName = humanName;
  }

  public DataFilePropertiesModelPropertyToMapTo modelName(String modelName) {
    this.modelName = modelName;
    return this;
  }

  /**
   * Get modelName
   * @return modelName
  **/
  @ApiModelProperty(value = "")

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesModelPropertyToMapTo dataFilePropertiesModelPropertyToMapTo = (DataFilePropertiesModelPropertyToMapTo) o;
    return Objects.equals(this.humanName, dataFilePropertiesModelPropertyToMapTo.humanName) &&
        Objects.equals(this.modelName, dataFilePropertiesModelPropertyToMapTo.modelName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(humanName, modelName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesModelPropertyToMapTo {\n");
    
    sb.append("    humanName: ").append(toIndentedString(humanName)).append("\n");
    sb.append("    modelName: ").append(toIndentedString(modelName)).append("\n");
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
