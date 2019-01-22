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
 * MineName
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-16T10:40:16.301Z[GMT]")

public class MineName   {
  @JsonProperty("mineName")
  private String mineName = null;

  @JsonProperty("userName")
  private String userName = null;

  public MineName mineName(String mineName) {
    this.mineName = mineName;
    return this;
  }

  /**
   * Get mineName
   * @return mineName
  **/
  @ApiModelProperty(example = "myFirstDatabase", required = true, value = "")
  @NotNull


  public String getMineName() {
    return mineName;
  }

  public void setMineName(String mineName) {
    this.mineName = mineName;
  }

  public MineName userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  **/
  @ApiModelProperty(example = "AliceLab", value = "")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MineName mineName = (MineName) o;
    return Objects.equals(this.mineName, mineName.mineName) &&
        Objects.equals(this.userName, mineName.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mineName, userName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MineName {\n");
    
    sb.append("    mineName: ").append(toIndentedString(mineName)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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

