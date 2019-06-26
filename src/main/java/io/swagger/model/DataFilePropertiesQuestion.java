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
 * DataFilePropertiesQuestion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-25T11:51:24.013Z[GMT]")
public class DataFilePropertiesQuestion   {
  @JsonProperty("questionId")
  private String questionId = null;

  @JsonProperty("questionHeader")
  private String questionHeader = null;

  @JsonProperty("questionWording")
  private String questionWording = null;

  @JsonProperty("possibleAnswers")
  @Valid
  private List<DataFilePropertiesAnswerOption> possibleAnswers = new ArrayList<DataFilePropertiesAnswerOption>();

  public DataFilePropertiesQuestion questionId(String questionId) {
    this.questionId = questionId;
    return this;
  }

  /**
   * Get questionId
   * @return questionId
  **/
  @ApiModelProperty(example = "nucleotideOrProtein", required = true, value = "")
  @NotNull

  public String getQuestionId() {
    return questionId;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }

  public DataFilePropertiesQuestion questionHeader(String questionHeader) {
    this.questionHeader = questionHeader;
    return this;
  }

  /**
   * A header in bold above question for readability
   * @return questionHeader
  **/
  @ApiModelProperty(example = "Sequence Type", required = true, value = "A header in bold above question for readability")
  @NotNull

  public String getQuestionHeader() {
    return questionHeader;
  }

  public void setQuestionHeader(String questionHeader) {
    this.questionHeader = questionHeader;
  }

  public DataFilePropertiesQuestion questionWording(String questionWording) {
    this.questionWording = questionWording;
    return this;
  }

  /**
   * The text of the question
   * @return questionWording
  **/
  @ApiModelProperty(example = "Does this file contain nucleotides or proteins?", value = "The text of the question")

  public String getQuestionWording() {
    return questionWording;
  }

  public void setQuestionWording(String questionWording) {
    this.questionWording = questionWording;
  }

  public DataFilePropertiesQuestion possibleAnswers(List<DataFilePropertiesAnswerOption> possibleAnswers) {
    this.possibleAnswers = possibleAnswers;
    return this;
  }

  public DataFilePropertiesQuestion addPossibleAnswersItem(DataFilePropertiesAnswerOption possibleAnswersItem) {
    this.possibleAnswers.add(possibleAnswersItem);
    return this;
  }

  /**
   * Get possibleAnswers
   * @return possibleAnswers
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
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
    DataFilePropertiesQuestion dataFilePropertiesQuestion = (DataFilePropertiesQuestion) o;
    return Objects.equals(this.questionId, dataFilePropertiesQuestion.questionId) &&
        Objects.equals(this.questionHeader, dataFilePropertiesQuestion.questionHeader) &&
        Objects.equals(this.questionWording, dataFilePropertiesQuestion.questionWording) &&
        Objects.equals(this.possibleAnswers, dataFilePropertiesQuestion.possibleAnswers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionId, questionHeader, questionWording, possibleAnswers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesQuestion {\n");
    
    sb.append("    questionId: ").append(toIndentedString(questionId)).append("\n");
    sb.append("    questionHeader: ").append(toIndentedString(questionHeader)).append("\n");
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
