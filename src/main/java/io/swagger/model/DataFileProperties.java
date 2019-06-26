package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFileDescriptor;
import io.swagger.model.DataFilePropertiesQuestion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * All of the config input by the user via the wizard
 */
@ApiModel(description = "All of the config input by the user via the wizard")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-25T11:51:24.013Z[GMT]")
public class DataFileProperties   {
  @JsonProperty("dataFile")
  private Object dataFile = null;

  @JsonProperty("descriptors")
  @Valid
  private List<DataFileDescriptor> descriptors = null;

  @JsonProperty("filePreview")
  private Object filePreview = null;

  @JsonProperty("questions")
  @Valid
  private List<DataFilePropertiesQuestion> questions = null;

  public DataFileProperties dataFile(Object dataFile) {
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

  public DataFileProperties descriptors(List<DataFileDescriptor> descriptors) {
    this.descriptors = descriptors;
    return this;
  }

  public DataFileProperties addDescriptorsItem(DataFileDescriptor descriptorsItem) {
    if (this.descriptors == null) {
      this.descriptors = new ArrayList<DataFileDescriptor>();
    }
    this.descriptors.add(descriptorsItem);
    return this;
  }

  /**
   * Information about the file, e.g. entity count, sequence type
   * @return descriptors
  **/
  @ApiModelProperty(value = "Information about the file, e.g. entity count, sequence type")
  @Valid
  public List<DataFileDescriptor> getDescriptors() {
    return descriptors;
  }

  public void setDescriptors(List<DataFileDescriptor> descriptors) {
    this.descriptors = descriptors;
  }

  public DataFileProperties filePreview(Object filePreview) {
    this.filePreview = filePreview;
    return this;
  }

  /**
   * Get filePreview
   * @return filePreview
  **/
  @ApiModelProperty(value = "")

  public Object getFilePreview() {
    return filePreview;
  }

  public void setFilePreview(Object filePreview) {
    this.filePreview = filePreview;
  }

  public DataFileProperties questions(List<DataFilePropertiesQuestion> questions) {
    this.questions = questions;
    return this;
  }

  public DataFileProperties addQuestionsItem(DataFilePropertiesQuestion questionsItem) {
    if (this.questions == null) {
      this.questions = new ArrayList<DataFilePropertiesQuestion>();
    }
    this.questions.add(questionsItem);
    return this;
  }

  /**
   * Get questions
   * @return questions
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<DataFilePropertiesQuestion> getQuestions() {
    return questions;
  }

  public void setQuestions(List<DataFilePropertiesQuestion> questions) {
    this.questions = questions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFileProperties dataFileProperties = (DataFileProperties) o;
    return Objects.equals(this.dataFile, dataFileProperties.dataFile) &&
        Objects.equals(this.descriptors, dataFileProperties.descriptors) &&
        Objects.equals(this.filePreview, dataFileProperties.filePreview) &&
        Objects.equals(this.questions, dataFileProperties.questions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataFile, descriptors, filePreview, questions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFileProperties {\n");
    
    sb.append("    dataFile: ").append(toIndentedString(dataFile)).append("\n");
    sb.append("    descriptors: ").append(toIndentedString(descriptors)).append("\n");
    sb.append("    filePreview: ").append(toIndentedString(filePreview)).append("\n");
    sb.append("    questions: ").append(toIndentedString(questions)).append("\n");
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
