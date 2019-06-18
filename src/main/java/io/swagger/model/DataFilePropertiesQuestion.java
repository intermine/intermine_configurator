package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesQuestionQuestion;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePropertiesQuestion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-18T08:43:54.303Z[GMT]")
public class DataFilePropertiesQuestion   {
  @JsonProperty("fileId")
  private UUID fileId = null;

  @JsonProperty("mineId")
  private String mineId = null;

  @JsonProperty("question")
  private DataFilePropertiesQuestionQuestion question = null;

  public DataFilePropertiesQuestion fileId(UUID fileId) {
    this.fileId = fileId;
    return this;
  }

  /**
   * Get fileId
   * @return fileId
  **/
  @ApiModelProperty(example = "03641b4d-bd7e-402f-803a-7aaf55c17238", required = true, value = "")
  @NotNull

  @Valid
  public UUID getFileId() {
    return fileId;
  }

  public void setFileId(UUID fileId) {
    this.fileId = fileId;
  }

  public DataFilePropertiesQuestion mineId(String mineId) {
    this.mineId = mineId;
    return this;
  }

  /**
   * Get mineId
   * @return mineId
  **/
  @ApiModelProperty(example = "123e4567-e89b-12d3-a456-556642440000", required = true, value = "")
  @NotNull

  public String getMineId() {
    return mineId;
  }

  public void setMineId(String mineId) {
    this.mineId = mineId;
  }

  public DataFilePropertiesQuestion question(DataFilePropertiesQuestionQuestion question) {
    this.question = question;
    return this;
  }

  /**
   * Get question
   * @return question
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public DataFilePropertiesQuestionQuestion getQuestion() {
    return question;
  }

  public void setQuestion(DataFilePropertiesQuestionQuestion question) {
    this.question = question;
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
    return Objects.equals(this.fileId, dataFilePropertiesQuestion.fileId) &&
        Objects.equals(this.mineId, dataFilePropertiesQuestion.mineId) &&
        Objects.equals(this.question, dataFilePropertiesQuestion.question);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileId, mineId, question);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesQuestion {\n");
    
    sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
    sb.append("    mineId: ").append(toIndentedString(mineId)).append("\n");
    sb.append("    question: ").append(toIndentedString(question)).append("\n");
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
