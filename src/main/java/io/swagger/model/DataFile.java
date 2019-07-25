package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents the data file
 */
@ApiModel(description = "Represents the data file")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-27T09:01:47.965Z[GMT]")
public class DataFile   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("fileId")
  private UUID fileId = null;

  /**
   * Gets or Sets fileFormat
   */
  public enum FileFormatEnum {
    FASTA("fasta"),
    
    GFF("gff3"),
    
    TAB("tab"),
    
    CSV("csv");

    private String value;

    FileFormatEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FileFormatEnum fromValue(String text) {
      for (FileFormatEnum b : FileFormatEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("fileFormat")
  private FileFormatEnum fileFormat = null;

  @JsonProperty("organism")
  private Organism organism = null;

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

  public DataFile fileId(UUID fileId) {
    this.fileId = fileId;
    return this;
  }

  /**
   * Get fileId
   * @return fileId
  **/
  @ApiModelProperty(example = "03641b4d-bd7e-402f-803a-7aaf55c17238", required = true, value = "")
  @NotNull

  @Valid
  public UUID getFileId() {
    return fileId;
  }

  public void setFileId(UUID fileId) {
    this.fileId = fileId;
  }

  public DataFile fileFormat(FileFormatEnum fileFormat) {
    this.fileFormat = fileFormat;
    return this;
  }

  /**
   * Get fileFormat
   * @return fileFormat
  **/
  @ApiModelProperty(example = "fasta", required = true, value = "")
  @NotNull

  public FileFormatEnum getFileFormat() {
    return fileFormat;
  }

  public void setFileFormat(FileFormatEnum fileFormat) {
    this.fileFormat = fileFormat;
  }

  public DataFile organism(Organism organism) {
    this.organism = organism;
    return this;
  }

  /**
   * Get organism
   * @return organism
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Organism getOrganism() {
    return organism;
  }

  public void setOrganism(Organism organism) {
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
        Objects.equals(this.fileId, dataFile.fileId) &&
        Objects.equals(this.fileFormat, dataFile.fileFormat) &&
        Objects.equals(this.organism, dataFile.organism);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, fileId, fileFormat, organism);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFile {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
    sb.append("    fileFormat: ").append(toIndentedString(fileFormat)).append("\n");
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
