package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFileRow;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePreview
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-24T09:08:54.055Z[GMT]")
public class DataFilePreview   {
  @JsonProperty("headerRowLabel")
  private String headerRowLabel = null;

  @JsonProperty("headerRow")
  @Valid
  private List<String> headerRow = null;

  @JsonProperty("fileRowLabel")
  private String fileRowLabel = null;

  @JsonProperty("fileRows")
  @Valid
  private List<DataFileRow> fileRows = null;

  public DataFilePreview headerRowLabel(String headerRowLabel) {
    this.headerRowLabel = headerRowLabel;
    return this;
  }

  /**
   * Bold header to label the header row in the file preview
   * @return headerRowLabel
  **/
  @ApiModelProperty(example = "Header row", value = "Bold header to label the header row in the file preview")

  public String getHeaderRowLabel() {
    return headerRowLabel;
  }

  public void setHeaderRowLabel(String headerRowLabel) {
    this.headerRowLabel = headerRowLabel;
  }

  public DataFilePreview headerRow(List<String> headerRow) {
    this.headerRow = headerRow;
    return this;
  }

  public DataFilePreview addHeaderRowItem(String headerRowItem) {
    if (this.headerRow == null) {
      this.headerRow = new ArrayList<String>();
    }
    this.headerRow.add(headerRowItem);
    return this;
  }

  /**
   * The header row of the data file
   * @return headerRow
  **/
  @ApiModelProperty(value = "The header row of the data file")

  public List<String> getHeaderRow() {
    return headerRow;
  }

  public void setHeaderRow(List<String> headerRow) {
    this.headerRow = headerRow;
  }

  public DataFilePreview fileRowLabel(String fileRowLabel) {
    this.fileRowLabel = fileRowLabel;
    return this;
  }

  /**
   * Bold header to label the file snippet in the file preview
   * @return fileRowLabel
  **/
  @ApiModelProperty(example = "Sequence", value = "Bold header to label the file snippet in the file preview")

  public String getFileRowLabel() {
    return fileRowLabel;
  }

  public void setFileRowLabel(String fileRowLabel) {
    this.fileRowLabel = fileRowLabel;
  }

  public DataFilePreview fileRows(List<DataFileRow> fileRows) {
    this.fileRows = fileRows;
    return this;
  }

  public DataFilePreview addFileRowsItem(DataFileRow fileRowsItem) {
    if (this.fileRows == null) {
      this.fileRows = new ArrayList<DataFileRow>();
    }
    this.fileRows.add(fileRowsItem);
    return this;
  }

  /**
   * Zero to many rows of the data file for display
   * @return fileRows
  **/
  @ApiModelProperty(value = "Zero to many rows of the data file for display")
  @Valid
  public List<DataFileRow> getFileRows() {
    return fileRows;
  }

  public void setFileRows(List<DataFileRow> fileRows) {
    this.fileRows = fileRows;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePreview dataFilePreview = (DataFilePreview) o;
    return Objects.equals(this.headerRowLabel, dataFilePreview.headerRowLabel) &&
        Objects.equals(this.headerRow, dataFilePreview.headerRow) &&
        Objects.equals(this.fileRowLabel, dataFilePreview.fileRowLabel) &&
        Objects.equals(this.fileRows, dataFilePreview.fileRows);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headerRowLabel, headerRow, fileRowLabel, fileRows);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePreview {\n");
    
    sb.append("    headerRowLabel: ").append(toIndentedString(headerRowLabel)).append("\n");
    sb.append("    headerRow: ").append(toIndentedString(headerRow)).append("\n");
    sb.append("    fileRowLabel: ").append(toIndentedString(fileRowLabel)).append("\n");
    sb.append("    fileRows: ").append(toIndentedString(fileRows)).append("\n");
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
