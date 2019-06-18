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
 * DataFilePropertiesResponseInnerAnswers
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-18T08:43:54.303Z[GMT]")
public class DataFilePropertiesResponseInnerAnswers   {
  @JsonProperty("answerID")
  private String answerID = null;

  @JsonProperty("answerChosen")
  private String answerChosen = null;

  public DataFilePropertiesResponseInnerAnswers answerID(String answerID) {
    this.answerID = answerID;
    return this;
  }

  /**
   * Get answerID
   * @return answerID
  **/
  @ApiModelProperty(example = "GeneID", value = "")

  public String getAnswerID() {
    return answerID;
  }

  public void setAnswerID(String answerID) {
    this.answerID = answerID;
  }

  public DataFilePropertiesResponseInnerAnswers answerChosen(String answerChosen) {
    this.answerChosen = answerChosen;
    return this;
  }

  /**
   * Get answerChosen
   * @return answerChosen
  **/
  @ApiModelProperty(example = "primaryIdentifier", value = "")

  public String getAnswerChosen() {
    return answerChosen;
  }

  public void setAnswerChosen(String answerChosen) {
    this.answerChosen = answerChosen;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesResponseInnerAnswers dataFilePropertiesResponseInnerAnswers = (DataFilePropertiesResponseInnerAnswers) o;
    return Objects.equals(this.answerID, dataFilePropertiesResponseInnerAnswers.answerID) &&
        Objects.equals(this.answerChosen, dataFilePropertiesResponseInnerAnswers.answerChosen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answerID, answerChosen);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesResponseInnerAnswers {\n");
    
    sb.append("    answerID: ").append(toIndentedString(answerID)).append("\n");
    sb.append("    answerChosen: ").append(toIndentedString(answerChosen)).append("\n");
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
