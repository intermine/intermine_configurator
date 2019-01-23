package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataBuildStatus
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-23T15:20:22.668Z[GMT]")
public class DataBuildStatus   {
  /**
   * Gets or Sets buildStatus
   */
  public enum BuildStatusEnum {
    COMPLETE("complete"),
    
    RUNNING("running"),
    
    ERRORED("errored"),
    
    NOT_YET_STARTED("not_yet_started");

    private String value;

    BuildStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static BuildStatusEnum fromValue(String text) {
      for (BuildStatusEnum b : BuildStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("buildStatus")
  private BuildStatusEnum buildStatus = null;

  @JsonProperty("errorDetails")
  private String errorDetails = null;

  public DataBuildStatus buildStatus(BuildStatusEnum buildStatus) {
    this.buildStatus = buildStatus;
    return this;
  }

  /**
   * Get buildStatus
   * @return buildStatus
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public BuildStatusEnum getBuildStatus() {
    return buildStatus;
  }

  public void setBuildStatus(BuildStatusEnum buildStatus) {
    this.buildStatus = buildStatus;
  }

  public DataBuildStatus errorDetails(String errorDetails) {
    this.errorDetails = errorDetails;
    return this;
  }

  /**
   * Get errorDetails
   * @return errorDetails
  **/
  @ApiModelProperty(value = "")

  public String getErrorDetails() {
    return errorDetails;
  }

  public void setErrorDetails(String errorDetails) {
    this.errorDetails = errorDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataBuildStatus dataBuildStatus = (DataBuildStatus) o;
    return Objects.equals(this.buildStatus, dataBuildStatus.buildStatus) &&
        Objects.equals(this.errorDetails, dataBuildStatus.errorDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buildStatus, errorDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataBuildStatus {\n");
    
    sb.append("    buildStatus: ").append(toIndentedString(buildStatus)).append("\n");
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
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
