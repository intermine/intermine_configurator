package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesResponseInnerMappedColumns;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePropertiesResponseInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
public class DataFilePropertiesResponseInner   {
  @JsonProperty("mappedColumns")
  @Valid
  private List<DataFilePropertiesResponseInnerMappedColumns> mappedColumns = null;

  @JsonProperty("organism")
  private Object organism = null;

  @JsonProperty("fileID")
  private Integer fileID = null;

  @JsonProperty("mineID")
  private String mineID = null;

  public DataFilePropertiesResponseInner mappedColumns(List<DataFilePropertiesResponseInnerMappedColumns> mappedColumns) {
    this.mappedColumns = mappedColumns;
    return this;
  }

  public DataFilePropertiesResponseInner addMappedColumnsItem(DataFilePropertiesResponseInnerMappedColumns mappedColumnsItem) {
    if (this.mappedColumns == null) {
      this.mappedColumns = new ArrayList<DataFilePropertiesResponseInnerMappedColumns>();
    }
    this.mappedColumns.add(mappedColumnsItem);
    return this;
  }

  /**
   * Get mappedColumns
   * @return mappedColumns
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<DataFilePropertiesResponseInnerMappedColumns> getMappedColumns() {
    return mappedColumns;
  }

  public void setMappedColumns(List<DataFilePropertiesResponseInnerMappedColumns> mappedColumns) {
    this.mappedColumns = mappedColumns;
  }

  public DataFilePropertiesResponseInner organism(Object organism) {
    this.organism = organism;
    return this;
  }

  /**
   * Get organism
   * @return organism
  **/
  @ApiModelProperty(value = "")

  public Object getOrganism() {
    return organism;
  }

  public void setOrganism(Object organism) {
    this.organism = organism;
  }

  public DataFilePropertiesResponseInner fileID(Integer fileID) {
    this.fileID = fileID;
    return this;
  }

  /**
   * Get fileID
   * @return fileID
  **/
  @ApiModelProperty(value = "")

  public Integer getFileID() {
    return fileID;
  }

  public void setFileID(Integer fileID) {
    this.fileID = fileID;
  }

  public DataFilePropertiesResponseInner mineID(String mineID) {
    this.mineID = mineID;
    return this;
  }

  /**
   * Get mineID
   * @return mineID
  **/
  @ApiModelProperty(value = "")

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
    DataFilePropertiesResponseInner dataFilePropertiesResponseInner = (DataFilePropertiesResponseInner) o;
    return Objects.equals(this.mappedColumns, dataFilePropertiesResponseInner.mappedColumns) &&
        Objects.equals(this.organism, dataFilePropertiesResponseInner.organism) &&
        Objects.equals(this.fileID, dataFilePropertiesResponseInner.fileID) &&
        Objects.equals(this.mineID, dataFilePropertiesResponseInner.mineID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mappedColumns, organism, fileID, mineID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesResponseInner {\n");
    
    sb.append("    mappedColumns: ").append(toIndentedString(mappedColumns)).append("\n");
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
