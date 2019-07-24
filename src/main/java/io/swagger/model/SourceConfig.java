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
 * SourceConfig
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-24T07:15:01.894Z[GMT]")
public class SourceConfig   {
  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("fileContents")
  private String fileContents = null;

  public SourceConfig fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * Get fileName
   * @return fileName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public SourceConfig fileContents(String fileContents) {
    this.fileContents = fileContents;
    return this;
  }

  /**
   * Get fileContents
   * @return fileContents
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getFileContents() {
    return fileContents;
  }

  public void setFileContents(String fileContents) {
    this.fileContents = fileContents;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceConfig sourceConfig = (SourceConfig) o;
    return Objects.equals(this.fileName, sourceConfig.fileName) &&
        Objects.equals(this.fileContents, sourceConfig.fileContents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileName, fileContents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceConfig {\n");
    
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    fileContents: ").append(toIndentedString(fileContents)).append("\n");
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
