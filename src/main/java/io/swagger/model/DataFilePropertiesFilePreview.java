package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePropertiesFilePreview
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-30T07:36:59.085Z[GMT]")
public class DataFilePropertiesFilePreview   {
  @JsonProperty("headerRow")
  @Valid
  private List<String> headerRow = null;

  @JsonProperty("rows")
  @Valid
  private List<List<String>> rows = null;

  public DataFilePropertiesFilePreview headerRow(List<String> headerRow) {
    this.headerRow = headerRow;
    return this;
  }

  public DataFilePropertiesFilePreview addHeaderRowItem(String headerRowItem) {
    if (this.headerRow == null) {
      this.headerRow = new ArrayList<String>();
    }
    this.headerRow.add(headerRowItem);
    return this;
  }

  /**
   * Get headerRow
   * @return headerRow
  **/
  @ApiModelProperty(value = "")

  public List<String> getHeaderRow() {
    return headerRow;
  }

  public void setHeaderRow(List<String> headerRow) {
    this.headerRow = headerRow;
  }

  public DataFilePropertiesFilePreview rows(List<List<String>> rows) {
    this.rows = rows;
    return this;
  }

  public DataFilePropertiesFilePreview addRowsItem(List<String> rowsItem) {
    if (this.rows == null) {
      this.rows = new ArrayList<List<String>>();
    }
    this.rows.add(rowsItem);
    return this;
  }

  /**
   * Get rows
   * @return rows
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<List<String>> getRows() {
    return rows;
  }

  public void setRows(List<List<String>> rows) {
    this.rows = rows;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesFilePreview dataFilePropertiesFilePreview = (DataFilePropertiesFilePreview) o;
    return Objects.equals(this.headerRow, dataFilePropertiesFilePreview.headerRow) &&
        Objects.equals(this.rows, dataFilePropertiesFilePreview.rows);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headerRow, rows);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesFilePreview {\n");
    
    sb.append("    headerRow: ").append(toIndentedString(headerRow)).append("\n");
    sb.append("    rows: ").append(toIndentedString(rows)).append("\n");
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
