package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MineConfig
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-22T09:44:44.307Z[GMT]")
public class MineConfig   {
  @JsonProperty("mineName")
  private String mineName = null;

  /**
   * Gets or Sets privacy
   */
  public enum PrivacyEnum {
    UNLISTED("unlisted"),
    
    PUBLIC("public");

    private String value;

    PrivacyEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PrivacyEnum fromValue(String text) {
      for (PrivacyEnum b : PrivacyEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("privacy")
  private PrivacyEnum privacy = null;

  @JsonProperty("licence")
  private String licence = null;

  public MineConfig mineName(String mineName) {
    this.mineName = mineName;
    return this;
  }

  /**
   * Get mineName
   * @return mineName
  **/
  @ApiModelProperty(example = "MyFirstMine", value = "")

  public String getMineName() {
    return mineName;
  }

  public void setMineName(String mineName) {
    this.mineName = mineName;
  }

  public MineConfig privacy(PrivacyEnum privacy) {
    this.privacy = privacy;
    return this;
  }

  /**
   * Get privacy
   * @return privacy
  **/
  @ApiModelProperty(example = "unlisted", value = "")

  public PrivacyEnum getPrivacy() {
    return privacy;
  }

  public void setPrivacy(PrivacyEnum privacy) {
    this.privacy = privacy;
  }

  public MineConfig licence(String licence) {
    this.licence = licence;
    return this;
  }

  /**
   * Get licence
   * @return licence
  **/
  @ApiModelProperty(example = "CC0", value = "")

  public String getLicence() {
    return licence;
  }

  public void setLicence(String licence) {
    this.licence = licence;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MineConfig mineConfig = (MineConfig) o;
    return Objects.equals(this.mineName, mineConfig.mineName) &&
        Objects.equals(this.privacy, mineConfig.privacy) &&
        Objects.equals(this.licence, mineConfig.licence);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mineName, privacy, licence);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MineConfig {\n");
    
    sb.append("    mineName: ").append(toIndentedString(mineName)).append("\n");
    sb.append("    privacy: ").append(toIndentedString(privacy)).append("\n");
    sb.append("    licence: ").append(toIndentedString(licence)).append("\n");
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
