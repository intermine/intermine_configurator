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
 * Organism
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
public class Organism   {
  @JsonProperty("taxonID")
  private Integer taxonID = null;

  public Organism taxonID(Integer taxonID) {
    this.taxonID = taxonID;
    return this;
  }

  /**
   * Get taxonID
   * @return taxonID
  **/
  @ApiModelProperty(example = "9606", required = true, value = "")
  @NotNull

  public Integer getTaxonID() {
    return taxonID;
  }

  public void setTaxonID(Integer taxonID) {
    this.taxonID = taxonID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organism organism = (Organism) o;
    return Objects.equals(this.taxonID, organism.taxonID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxonID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organism {\n");
    
    sb.append("    taxonID: ").append(toIndentedString(taxonID)).append("\n");
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
