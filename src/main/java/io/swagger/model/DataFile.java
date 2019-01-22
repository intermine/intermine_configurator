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
 * DataFile
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
public class DataFile   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("fileContents")
  private String fileContents = null;

  @JsonProperty("organism")
  private Object organism = null;

  public DataFile name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "humanfile.gff", required = true, value = "")
  @NotNull

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DataFile fileContents(String fileContents) {
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

  public DataFile organism(Object organism) {
    this.organism = organism;
    return this;
  }

  /**
   * Get organism
   * @return organism
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Object getOrganism() {
    return organism;
  }

  public void setOrganism(Object organism) {
    this.organism = organism;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFile dataFile = (DataFile) o;
    return Objects.equals(this.name, dataFile.name) &&
        Objects.equals(this.fileContents, dataFile.fileContents) &&
        Objects.equals(this.organism, dataFile.organism);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, fileContents, organism);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFile {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fileContents: ").append(toIndentedString(fileContents)).append("\n");
    sb.append("    organism: ").append(toIndentedString(organism)).append("\n");
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
