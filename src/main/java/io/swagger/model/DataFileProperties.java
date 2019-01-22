package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesColumnsToMap;
import io.swagger.model.DataFilePropertiesFilePreview;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFileProperties
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
public class DataFileProperties   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("fileFormat")
  private String fileFormat = null;

  @JsonProperty("rowCount")
  private Integer rowCount = null;

  @JsonProperty("filePreview")
  private DataFilePropertiesFilePreview filePreview = null;

  @JsonProperty("columnsToMap")
  @Valid
  private List<DataFilePropertiesColumnsToMap> columnsToMap = null;

  @JsonProperty("organism")
  private Object organism = null;

  @JsonProperty("fileID")
  private Integer fileID = null;

  @JsonProperty("mineID")
  private String mineID = null;

  public DataFileProperties name(String name) {
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

  public DataFileProperties fileFormat(String fileFormat) {
    this.fileFormat = fileFormat;
    return this;
  }

  /**
   * Get fileFormat
   * @return fileFormat
  **/
  @ApiModelProperty(example = "gff", required = true, value = "")
  @NotNull

  public String getFileFormat() {
    return fileFormat;
  }

  public void setFileFormat(String fileFormat) {
    this.fileFormat = fileFormat;
  }

  public DataFileProperties rowCount(Integer rowCount) {
    this.rowCount = rowCount;
    return this;
  }

  /**
   * Get rowCount
   * @return rowCount
  **/
  @ApiModelProperty(example = "22395", required = true, value = "")
  @NotNull

  public Integer getRowCount() {
    return rowCount;
  }

  public void setRowCount(Integer rowCount) {
    this.rowCount = rowCount;
  }

  public DataFileProperties filePreview(DataFilePropertiesFilePreview filePreview) {
    this.filePreview = filePreview;
    return this;
  }

  /**
   * Get filePreview
   * @return filePreview
  **/
  @ApiModelProperty(value = "")

  @Valid
  public DataFilePropertiesFilePreview getFilePreview() {
    return filePreview;
  }

  public void setFilePreview(DataFilePropertiesFilePreview filePreview) {
    this.filePreview = filePreview;
  }

  public DataFileProperties columnsToMap(List<DataFilePropertiesColumnsToMap> columnsToMap) {
    this.columnsToMap = columnsToMap;
    return this;
  }

  public DataFileProperties addColumnsToMapItem(DataFilePropertiesColumnsToMap columnsToMapItem) {
    if (this.columnsToMap == null) {
      this.columnsToMap = new ArrayList<DataFilePropertiesColumnsToMap>();
    }
    this.columnsToMap.add(columnsToMapItem);
    return this;
  }

  /**
   * Get columnsToMap
   * @return columnsToMap
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<DataFilePropertiesColumnsToMap> getColumnsToMap() {
    return columnsToMap;
  }

  public void setColumnsToMap(List<DataFilePropertiesColumnsToMap> columnsToMap) {
    this.columnsToMap = columnsToMap;
  }

  public DataFileProperties organism(Object organism) {
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

  public DataFileProperties fileID(Integer fileID) {
    this.fileID = fileID;
    return this;
  }

  /**
   * Get fileID
   * @return fileID
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getFileID() {
    return fileID;
  }

  public void setFileID(Integer fileID) {
    this.fileID = fileID;
  }

  public DataFileProperties mineID(String mineID) {
    this.mineID = mineID;
    return this;
  }

  /**
   * Get mineID
   * @return mineID
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getMineID() {
    return mineID;
  }

  public void setMineID(String mineID) {
    this.mineID = mineID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFileProperties dataFileProperties = (DataFileProperties) o;
    return Objects.equals(this.name, dataFileProperties.name) &&
        Objects.equals(this.fileFormat, dataFileProperties.fileFormat) &&
        Objects.equals(this.rowCount, dataFileProperties.rowCount) &&
        Objects.equals(this.filePreview, dataFileProperties.filePreview) &&
        Objects.equals(this.columnsToMap, dataFileProperties.columnsToMap) &&
        Objects.equals(this.organism, dataFileProperties.organism) &&
        Objects.equals(this.fileID, dataFileProperties.fileID) &&
        Objects.equals(this.mineID, dataFileProperties.mineID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, fileFormat, rowCount, filePreview, columnsToMap, organism, fileID, mineID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFileProperties {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fileFormat: ").append(toIndentedString(fileFormat)).append("\n");
    sb.append("    rowCount: ").append(toIndentedString(rowCount)).append("\n");
    sb.append("    filePreview: ").append(toIndentedString(filePreview)).append("\n");
    sb.append("    columnsToMap: ").append(toIndentedString(columnsToMap)).append("\n");
    sb.append("    organism: ").append(toIndentedString(organism)).append("\n");
    sb.append("    fileID: ").append(toIndentedString(fileID)).append("\n");
    sb.append("    mineID: ").append(toIndentedString(mineID)).append("\n");
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
