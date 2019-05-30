package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesResponseInnerAnswers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePropertiesResponseInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-30T07:36:59.085Z[GMT]")
public class DataFilePropertiesResponseInner   {
  @JsonProperty("answers")
  @Valid
  private List<DataFilePropertiesResponseInnerAnswers> answers = null;

  @JsonProperty("fileLocation")
  private String fileLocation = null;

  @JsonProperty("mineID")
  private String mineID = null;

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

  public DataFilePropertiesResponseInner fileLocation(String fileLocation) {
    this.fileLocation = fileLocation;
    return this;
  }

  /**
   * Get fileLocation
   * @return fileLocation
  **/
  @ApiModelProperty(example = "/data/myGFF", required = true, value = "")
  @NotNull

  public String getFileLocation() {
    return fileLocation;
  }

  public void setFileLocation(String fileLocation) {
    this.fileLocation = fileLocation;
  }

  public DataFilePropertiesResponseInner mineID(String mineID) {
    this.mineID = mineID;
    return this;
  }

  /**
   * Get mineID
   * @return mineID
  **/
  @ApiModelProperty(example = "123e4567-e89b-12d3-a456-556642440000", required = true, value = "")
  @NotNull

  public String getMineID() {
    return mineID;
  }

  public void setMineID(String mineID) {
    this.mineID = mineID;
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
        Objects.equals(this.fileLocation, dataFilePropertiesResponseInner.fileLocation) &&
        Objects.equals(this.mineID, dataFilePropertiesResponseInner.mineID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answers, fileLocation, mineID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesResponseInner {\n");
    
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
    sb.append("    fileLocation: ").append(toIndentedString(fileLocation)).append("\n");
    sb.append("    mineID: ").append(toIndentedString(mineID)).append("\n");
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
