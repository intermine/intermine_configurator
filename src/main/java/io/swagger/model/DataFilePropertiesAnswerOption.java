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
 * DataFilePropertiesAnswerOption
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-25T11:51:24.013Z[GMT]")
public class DataFilePropertiesAnswerOption   {
  @JsonProperty("answerId")
  private String answerId = null;

  @JsonProperty("answerLabel")
  private String answerLabel = null;

  @JsonProperty("isDefault")
  private Boolean isDefault = null;

  @JsonProperty("isSelected")
  private Boolean isSelected = null;

  public DataFilePropertiesAnswerOption answerId(String answerId) {
    this.answerId = answerId;
    return this;
  }

  /**
   * Machine-readable value for this answer
   * @return answerId
  **/
  @ApiModelProperty(example = "primaryIdentifier", required = true, value = "Machine-readable value for this answer")
  @NotNull

  public String getAnswerId() {
    return answerId;
  }

  public void setAnswerId(String answerId) {
    this.answerId = answerId;
  }

  public DataFilePropertiesAnswerOption answerLabel(String answerLabel) {
    this.answerLabel = answerLabel;
    return this;
  }

  /**
   * Human readable answer to be displayed
   * @return answerLabel
  **/
  @ApiModelProperty(example = "Primary Identifier", required = true, value = "Human readable answer to be displayed")
  @NotNull

  public String getAnswerLabel() {
    return answerLabel;
  }

  public void setAnswerLabel(String answerLabel) {
    this.answerLabel = answerLabel;
  }

  public DataFilePropertiesAnswerOption isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  /**
   * TRUE if this is the default value
   * @return isDefault
  **/
  @ApiModelProperty(example = "true", value = "TRUE if this is the default value")

  public Boolean isIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public DataFilePropertiesAnswerOption isSelected(Boolean isSelected) {
    this.isSelected = isSelected;
    return this;
  }

  /**
   * TRUE if the user selected this value in the wizard
   * @return isSelected
  **/
  @ApiModelProperty(example = "false", value = "TRUE if the user selected this value in the wizard")

  public Boolean isIsSelected() {
    return isSelected;
  }

  public void setIsSelected(Boolean isSelected) {
    this.isSelected = isSelected;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesAnswerOption dataFilePropertiesAnswerOption = (DataFilePropertiesAnswerOption) o;
    return Objects.equals(this.answerId, dataFilePropertiesAnswerOption.answerId) &&
        Objects.equals(this.answerLabel, dataFilePropertiesAnswerOption.answerLabel) &&
        Objects.equals(this.isDefault, dataFilePropertiesAnswerOption.isDefault) &&
        Objects.equals(this.isSelected, dataFilePropertiesAnswerOption.isSelected);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answerId, answerLabel, isDefault, isSelected);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesAnswerOption {\n");
    
    sb.append("    answerId: ").append(toIndentedString(answerId)).append("\n");
    sb.append("    answerLabel: ").append(toIndentedString(answerLabel)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    isSelected: ").append(toIndentedString(isSelected)).append("\n");
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
