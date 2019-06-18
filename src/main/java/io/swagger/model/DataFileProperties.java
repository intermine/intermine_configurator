package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFilePropertiesFilePreview;
import io.swagger.model.DataFilePropertiesQuestion;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataFileProperties
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-18T10:19:50.598Z[GMT]")
public class DataFileProperties   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("fileFormat")
  private String fileFormat = null;

  @JsonProperty("rowCount")
  private Integer rowCount = null;

  @JsonProperty("filePreview")
  private DataFilePropertiesFilePreview filePreview = null;

  @JsonProperty("questions")
  @Valid
  private List<DataFilePropertiesQuestion> questions = null;

  @JsonProperty("fileId")
  private UUID fileId = null;

  @JsonProperty("mineId")
  private String mineId = null;

  @JsonProperty("organism")
  private Object organism = null;

  public DataFileProperties name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "humanfile.gff", required = true, value = "")
  @NotNull

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DataFileProperties fileFormat(String fileFormat) {
    this.fileFormat = fileFormat;
    return this;
  }

  /**
   * Get fileFormat
   * @return fileFormat
  **/
  @ApiModelProperty(example = "gff", required = true, value = "")
  @NotNull

  public String getFileFormat() {
    return fileFormat;
  }

  public void setFileFormat(String fileFormat) {
    this.fileFormat = fileFormat;
  }

  public DataFileProperties rowCount(Integer rowCount) {
    this.rowCount = rowCount;
    return this;
  }

  /**
   * Get rowCount
   * @return rowCount
  **/
  @ApiModelProperty(example = "22395", required = true, value = "")
  @NotNull

  public Integer getRowCount() {
    return rowCount;
  }

  public void setRowCount(Integer rowCount) {
    this.rowCount = rowCount;
  }

  public DataFileProperties filePreview(DataFilePropertiesFilePreview filePreview) {
    this.filePreview = filePreview;
    return this;
  }

  /**
   * Get filePreview
   * @return filePreview
  **/
  @ApiModelProperty(value = "")

  @Valid
  public DataFilePropertiesFilePreview getFilePreview() {
    return filePreview;
  }

  public void setFilePreview(DataFilePropertiesFilePreview filePreview) {
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

  public DataFileProperties fileId(UUID fileId) {
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

  public DataFileProperties mineId(String mineId) {
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

  public DataFileProperties organism(Object organism) {
    this.organism = organism;
    return this;
  }

  /**
   * Get organism
   * @return organism
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Object getOrganism() {
    return organism;
  }

  public void setOrganism(Object organism) {
    this.organism = organism;
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
    return Objects.equals(this.name, dataFileProperties.name) &&
        Objects.equals(this.fileFormat, dataFileProperties.fileFormat) &&
        Objects.equals(this.rowCount, dataFileProperties.rowCount) &&
        Objects.equals(this.filePreview, dataFileProperties.filePreview) &&
        Objects.equals(this.questions, dataFileProperties.questions) &&
        Objects.equals(this.fileId, dataFileProperties.fileId) &&
        Objects.equals(this.mineId, dataFileProperties.mineId) &&
        Objects.equals(this.organism, dataFileProperties.organism);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, fileFormat, rowCount, filePreview, questions, fileId, mineId, organism);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFileProperties {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fileFormat: ").append(toIndentedString(fileFormat)).append("\n");
    sb.append("    rowCount: ").append(toIndentedString(rowCount)).append("\n");
    sb.append("    filePreview: ").append(toIndentedString(filePreview)).append("\n");
    sb.append("    questions: ").append(toIndentedString(questions)).append("\n");
    sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
    sb.append("    mineId: ").append(toIndentedString(mineId)).append("\n");
    sb.append("    organism: ").append(toIndentedString(organism)).append("\n");
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
