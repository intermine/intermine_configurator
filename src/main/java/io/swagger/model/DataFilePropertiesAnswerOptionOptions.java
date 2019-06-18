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
 * DataFilePropertiesAnswerOptionOptions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-18T10:19:50.598Z[GMT]")
public class DataFilePropertiesAnswerOptionOptions   {
  @JsonProperty("answerID")
  private String answerID = null;

  @JsonProperty("answerWording")
  private String answerWording = null;

  public DataFilePropertiesAnswerOptionOptions answerID(String answerID) {
    this.answerID = answerID;
    return this;
  }

  /**
   * Get answerID
   * @return answerID
  **/
  @ApiModelProperty(example = "nucleotide", value = "")

  public String getAnswerID() {
    return answerID;
  }

  public void setAnswerID(String answerID) {
    this.answerID = answerID;
  }

  public DataFilePropertiesAnswerOptionOptions answerWording(String answerWording) {
    this.answerWording = answerWording;
    return this;
  }

  /**
   * Get answerWording
   * @return answerWording
  **/
  @ApiModelProperty(example = "Nucleotide", value = "")

  public String getAnswerWording() {
    return answerWording;
  }

  public void setAnswerWording(String answerWording) {
    this.answerWording = answerWording;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesAnswerOptionOptions dataFilePropertiesAnswerOptionOptions = (DataFilePropertiesAnswerOptionOptions) o;
    return Objects.equals(this.answerID, dataFilePropertiesAnswerOptionOptions.answerID) &&
        Objects.equals(this.answerWording, dataFilePropertiesAnswerOptionOptions.answerWording);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answerID, answerWording);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesAnswerOptionOptions {\n");
    
    sb.append("    answerID: ").append(toIndentedString(answerID)).append("\n");
    sb.append("    answerWording: ").append(toIndentedString(answerWording)).append("\n");
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
