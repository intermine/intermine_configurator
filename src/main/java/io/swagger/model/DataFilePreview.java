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
 * DataFilePreview
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-27T09:01:47.965Z[GMT]")
public class DataFilePreview   {
  @JsonProperty("headerLabel")
  private String headerLabel = null;

  @JsonProperty("headerRow")
  @Valid
  private List<String> headerRow = null;

  @JsonProperty("snippetLabel")
  private String snippetLabel = null;

  @JsonProperty("fileSnippet")
  @Valid
  private List<String> fileSnippet = null;

  public DataFilePreview headerLabel(String headerLabel) {
    this.headerLabel = headerLabel;
    return this;
  }

  /**
   * Bold header to label the header row in the file preview
   * @return headerLabel
  **/
  @ApiModelProperty(example = "Header row", value = "Bold header to label the header row in the file preview")

  public String getHeaderLabel() {
    return headerLabel;
  }

  public void setHeaderLabel(String headerLabel) {
    this.headerLabel = headerLabel;
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

  public DataFilePreview snippetLabel(String snippetLabel) {
    this.snippetLabel = snippetLabel;
    return this;
  }

  /**
   * Bold header to label the file snippet in the file preview
   * @return snippetLabel
  **/
  @ApiModelProperty(example = "Sequence", value = "Bold header to label the file snippet in the file preview")

  public String getSnippetLabel() {
    return snippetLabel;
  }

  public void setSnippetLabel(String snippetLabel) {
    this.snippetLabel = snippetLabel;
  }

  public DataFilePreview fileSnippet(List<String> fileSnippet) {
    this.fileSnippet = fileSnippet;
    return this;
  }

  public DataFilePreview addFileSnippetItem(String fileSnippetItem) {
    if (this.fileSnippet == null) {
      this.fileSnippet = new ArrayList<String>();
    }
    this.fileSnippet.add(fileSnippetItem);
    return this;
  }

  /**
   * The first interesting line of the file
   * @return fileSnippet
  **/
  @ApiModelProperty(value = "The first interesting line of the file")

  public List<String> getFileSnippet() {
    return fileSnippet;
  }

  public void setFileSnippet(List<String> fileSnippet) {
    this.fileSnippet = fileSnippet;
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
    return Objects.equals(this.headerLabel, dataFilePreview.headerLabel) &&
        Objects.equals(this.headerRow, dataFilePreview.headerRow) &&
        Objects.equals(this.snippetLabel, dataFilePreview.snippetLabel) &&
        Objects.equals(this.fileSnippet, dataFilePreview.fileSnippet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headerLabel, headerRow, snippetLabel, fileSnippet);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePreview {\n");
    
    sb.append("    headerLabel: ").append(toIndentedString(headerLabel)).append("\n");
    sb.append("    headerRow: ").append(toIndentedString(headerRow)).append("\n");
    sb.append("    snippetLabel: ").append(toIndentedString(snippetLabel)).append("\n");
    sb.append("    fileSnippet: ").append(toIndentedString(fileSnippet)).append("\n");
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
