package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesAnswerOption;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePropertiesQuestionQuestion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-30T09:11:48.356Z[GMT]")
public class DataFilePropertiesQuestionQuestion   {
  @JsonProperty("questionType")
  private String questionType = null;

  @JsonProperty("questionWording")
  private String questionWording = null;

  @JsonProperty("possibleAnswers")
  @Valid
  private List<DataFilePropertiesAnswerOption> possibleAnswers = null;

  public DataFilePropertiesQuestionQuestion questionType(String questionType) {
    this.questionType = questionType;
    return this;
  }

  /**
   * Get questionType
   * @return questionType
  **/
  @ApiModelProperty(example = "nucleotideOrProtein", value = "")

  public String getQuestionType() {
    return questionType;
  }

  public void setQuestionType(String questionType) {
    this.questionType = questionType;
  }

  public DataFilePropertiesQuestionQuestion questionWording(String questionWording) {
    this.questionWording = questionWording;
    return this;
  }

  /**
   * Human-readable question aimed at a wizard user.
   * @return questionWording
  **/
  @ApiModelProperty(example = "Does this file contain nucleotides or proteins?", value = "Human-readable question aimed at a wizard user.")

  public String getQuestionWording() {
    return questionWording;
  }

  public void setQuestionWording(String questionWording) {
    this.questionWording = questionWording;
  }

  public DataFilePropertiesQuestionQuestion possibleAnswers(List<DataFilePropertiesAnswerOption> possibleAnswers) {
    this.possibleAnswers = possibleAnswers;
    return this;
  }

  public DataFilePropertiesQuestionQuestion addPossibleAnswersItem(DataFilePropertiesAnswerOption possibleAnswersItem) {
    if (this.possibleAnswers == null) {
      this.possibleAnswers = new ArrayList<DataFilePropertiesAnswerOption>();
    }
    this.possibleAnswers.add(possibleAnswersItem);
    return this;
  }

  /**
   * Get possibleAnswers
   * @return possibleAnswers
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<DataFilePropertiesAnswerOption> getPossibleAnswers() {
    return possibleAnswers;
  }

  public void setPossibleAnswers(List<DataFilePropertiesAnswerOption> possibleAnswers) {
    this.possibleAnswers = possibleAnswers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesQuestionQuestion dataFilePropertiesQuestionQuestion = (DataFilePropertiesQuestionQuestion) o;
    return Objects.equals(this.questionType, dataFilePropertiesQuestionQuestion.questionType) &&
        Objects.equals(this.questionWording, dataFilePropertiesQuestionQuestion.questionWording) &&
        Objects.equals(this.possibleAnswers, dataFilePropertiesQuestionQuestion.possibleAnswers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionType, questionWording, possibleAnswers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesQuestionQuestion {\n");
    
    sb.append("    questionType: ").append(toIndentedString(questionType)).append("\n");
    sb.append("    questionWording: ").append(toIndentedString(questionWording)).append("\n");
    sb.append("    possibleAnswers: ").append(toIndentedString(possibleAnswers)).append("\n");
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
