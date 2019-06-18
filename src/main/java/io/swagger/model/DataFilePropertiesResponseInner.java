package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesResponseInnerAnswers;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePropertiesResponseInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-18T08:43:54.303Z[GMT]")
public class DataFilePropertiesResponseInner   {
  @JsonProperty("answers")
  @Valid
  private List<DataFilePropertiesResponseInnerAnswers> answers = null;

  @JsonProperty("fileId")
  private UUID fileId = null;

  @JsonProperty("mineId")
  private String mineId = null;

  public DataFilePropertiesResponseInner answers(List<DataFilePropertiesResponseInnerAnswers> answers) {
    this.answers = answers;
    return this;
  }

  public DataFilePropertiesResponseInner addAnswersItem(DataFilePropertiesResponseInnerAnswers answersItem) {
    if (this.answers == null) {
      this.answers = new ArrayList<DataFilePropertiesResponseInnerAnswers>();
    }
    this.answers.add(answersItem);
    return this;
  }

  /**
   * Get answers
   * @return answers
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<DataFilePropertiesResponseInnerAnswers> getAnswers() {
    return answers;
  }

  public void setAnswers(List<DataFilePropertiesResponseInnerAnswers> answers) {
    this.answers = answers;
  }

  public DataFilePropertiesResponseInner fileId(UUID fileId) {
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

  public DataFilePropertiesResponseInner mineId(String mineId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesResponseInner dataFilePropertiesResponseInner = (DataFilePropertiesResponseInner) o;
    return Objects.equals(this.answers, dataFilePropertiesResponseInner.answers) &&
        Objects.equals(this.fileId, dataFilePropertiesResponseInner.fileId) &&
        Objects.equals(this.mineId, dataFilePropertiesResponseInner.mineId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answers, fileId, mineId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesResponseInner {\n");
    
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
    sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
    sb.append("    mineId: ").append(toIndentedString(mineId)).append("\n");
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
