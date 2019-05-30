package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesAnswerOptionOptions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFilePropertiesAnswerOption
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-30T09:11:48.356Z[GMT]")
public class DataFilePropertiesAnswerOption   {
  @JsonProperty("fileLocation")
  private String fileLocation = null;

  @JsonProperty("mineId")
  private String mineId = null;

  @JsonProperty("options")
  @Valid
  private List<DataFilePropertiesAnswerOptionOptions> options = null;

  @JsonProperty("defaultAnswer")
  private String defaultAnswer = null;

  public DataFilePropertiesAnswerOption fileLocation(String fileLocation) {
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

  public DataFilePropertiesAnswerOption mineId(String mineId) {
    this.mineId = mineId;
    return this;
  }

  /**
   * Get mineId
   * @return mineId
  **/
  @ApiModelProperty(example = "123e4567-e89b-12d3-a456-556642440000", value = "")

  public String getMineId() {
    return mineId;
  }

  public void setMineId(String mineId) {
    this.mineId = mineId;
  }

  public DataFilePropertiesAnswerOption options(List<DataFilePropertiesAnswerOptionOptions> options) {
    this.options = options;
    return this;
  }

  public DataFilePropertiesAnswerOption addOptionsItem(DataFilePropertiesAnswerOptionOptions optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<DataFilePropertiesAnswerOptionOptions>();
    }
    this.options.add(optionsItem);
    return this;
  }

  /**
   * Array of possible answers the user can choose from.
   * @return options
  **/
  @ApiModelProperty(example = "[{\"answerID\":\"nucleotides\",\"answerWording\":\"Nucleotides\"},{\"answerID\":\"proteins\",\"answerWording\":\"Proteins\"}]", value = "Array of possible answers the user can choose from.")
  @Valid
  public List<DataFilePropertiesAnswerOptionOptions> getOptions() {
    return options;
  }

  public void setOptions(List<DataFilePropertiesAnswerOptionOptions> options) {
    this.options = options;
  }

  public DataFilePropertiesAnswerOption defaultAnswer(String defaultAnswer) {
    this.defaultAnswer = defaultAnswer;
    return this;
  }

  /**
   * Get defaultAnswer
   * @return defaultAnswer
  **/
  @ApiModelProperty(example = "answerID of one of the questions above", value = "")

  public String getDefaultAnswer() {
    return defaultAnswer;
  }

  public void setDefaultAnswer(String defaultAnswer) {
    this.defaultAnswer = defaultAnswer;
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
    return Objects.equals(this.fileLocation, dataFilePropertiesAnswerOption.fileLocation) &&
        Objects.equals(this.mineId, dataFilePropertiesAnswerOption.mineId) &&
        Objects.equals(this.options, dataFilePropertiesAnswerOption.options) &&
        Objects.equals(this.defaultAnswer, dataFilePropertiesAnswerOption.defaultAnswer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileLocation, mineId, options, defaultAnswer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFilePropertiesAnswerOption {\n");
    
    sb.append("    fileLocation: ").append(toIndentedString(fileLocation)).append("\n");
    sb.append("    mineId: ").append(toIndentedString(mineId)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    defaultAnswer: ").append(toIndentedString(defaultAnswer)).append("\n");
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
