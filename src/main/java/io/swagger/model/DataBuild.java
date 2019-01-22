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
 * DataBuild
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
public class DataBuild   {
  @JsonProperty("mineConfigId")
  private Integer mineConfigId = null;

  public DataBuild mineConfigId(Integer mineConfigId) {
    this.mineConfigId = mineConfigId;
    return this;
  }

  /**
   * Get mineConfigId
   * @return mineConfigId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getMineConfigId() {
    return mineConfigId;
  }

  public void setMineConfigId(Integer mineConfigId) {
    this.mineConfigId = mineConfigId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataBuild dataBuild = (DataBuild) o;
    return Objects.equals(this.mineConfigId, dataBuild.mineConfigId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mineConfigId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataBuild {\n");
    
    sb.append("    mineConfigId: ").append(toIndentedString(mineConfigId)).append("\n");
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
