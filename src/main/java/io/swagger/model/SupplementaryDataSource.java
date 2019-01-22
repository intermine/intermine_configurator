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
 * SupplementaryDataSource
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
public class SupplementaryDataSource   {
  @JsonProperty("label")
  private String label = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("url")
  private String url = null;

  public SupplementaryDataSource label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
  **/
  @ApiModelProperty(example = "NCBI Taxon ID information", required = true, value = "")
  @NotNull

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public SupplementaryDataSource description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "Will populate empty fields for Organism, e.g. name (Based on NCBI taxon ID)", required = true, value = "")
  @NotNull

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SupplementaryDataSource url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(example = "https://intermine.readthedocs.io/en/latest/database/data-sources/library/organism/", required = true, value = "")
  @NotNull

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SupplementaryDataSource supplementaryDataSource = (SupplementaryDataSource) o;
    return Objects.equals(this.label, supplementaryDataSource.label) &&
        Objects.equals(this.description, supplementaryDataSource.description) &&
        Objects.equals(this.url, supplementaryDataSource.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, description, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SupplementaryDataSource {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
