package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesResponseAnswers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePropertiesResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-25T11:51:24.013Z[GMT]")
public class DataFilePropertiesResponse   {
  @JsonProperty("dataFile")
  private Object dataFile = null;

  @JsonProperty("answers")
  @Valid
  private List<DataFilePropertiesResponseAnswers> answers = new ArrayList<DataFilePropertiesResponseAnswers>();

  public DataFilePropertiesResponse dataFile(Object dataFile) {
    this.dataFile = dataFile;
    return this;
  }

  /**
   * Get dataFile
   * @return dataFile
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Object getDataFile() {
    return dataFile;
  }

  public void setDataFile(Object dataFile) {
    this.dataFile = dataFile;
  }

  public DataFilePropertiesResponse answers(List<DataFilePropertiesResponseAnswers> answers) {
    this.answers = answers;
    return this;
  }

  public DataFilePropertiesResponse addAnswersItem(DataFilePropertiesResponseAnswers answersItem) {
    this.answers.add(answersItem);
    return this;
  }

  /**
   * Get answers
   * @return answers
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public List<DataFilePropertiesResponseAnswers> getAnswers() {
    return answers;
  }

  public void setAnswers(List<DataFilePropertiesResponseAnswers> answers) {
    this.answers = answers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFilePropertiesResponse dataFilePropertiesResponse = (DataFilePropertiesResponse) o;
    return Objects.equals(this.dataFile, dataFilePropertiesResponse.dataFile) &&
        Objects.equals(this.answers, dataFilePropertiesResponse.answers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataFile, answers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesResponse {\n");
    
    sb.append("    dataFile: ").append(toIndentedString(dataFile)).append("\n");
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
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
