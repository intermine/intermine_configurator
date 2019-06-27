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
 * DataFilePropertiesResponseAnswers
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-27T09:01:47.965Z[GMT]")
public class DataFilePropertiesResponseAnswers   {
  @JsonProperty("questionId")
  private String questionId = null;

  @JsonProperty("answerId")
  private String answerId = null;

  public DataFilePropertiesResponseAnswers questionId(String questionId) {
    this.questionId = questionId;
    return this;
  }

  /**
   * Get questionId
   * @return questionId
  **/
  @ApiModelProperty(example = "nucleotideOrProtein", value = "")

  public String getQuestionId() {
    return questionId;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }

  public DataFilePropertiesResponseAnswers answerId(String answerId) {
    this.answerId = answerId;
    return this;
  }

  /**
   * Get answerId
   * @return answerId
  **/
  @ApiModelProperty(example = "nucleotide", value = "")

  public String getAnswerId() {
    return answerId;
  }

  public void setAnswerId(String answerId) {
    this.answerId = answerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesResponseAnswers dataFilePropertiesResponseAnswers = (DataFilePropertiesResponseAnswers) o;
    return Objects.equals(this.questionId, dataFilePropertiesResponseAnswers.questionId) &&
        Objects.equals(this.answerId, dataFilePropertiesResponseAnswers.answerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionId, answerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesResponseAnswers {\n");
    
    sb.append("    questionId: ").append(toIndentedString(questionId)).append("\n");
    sb.append("    answerId: ").append(toIndentedString(answerId)).append("\n");
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
