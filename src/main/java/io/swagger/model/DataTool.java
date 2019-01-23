package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DataTool
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-23T15:20:22.668Z[GMT]")
public class DataTool   {
  @JsonProperty("toolId")
  private Integer toolId = null;

  @JsonProperty("toolName")
  private String toolName = null;

  @JsonProperty("toolDescription")
  private String toolDescription = null;

  @JsonProperty("toolPreview")
  private String toolPreview = null;

  @JsonProperty("requiredClasses")
  @Valid
  private List<String> requiredClasses = null;

  public DataTool toolId(Integer toolId) {
    this.toolId = toolId;
    return this;
  }

  /**
   * Get toolId
   * @return toolId
  **/
  @ApiModelProperty(value = "")

  public Integer getToolId() {
    return toolId;
  }

  public void setToolId(Integer toolId) {
    this.toolId = toolId;
  }

  public DataTool toolName(String toolName) {
    this.toolName = toolName;
    return this;
  }

  /**
   * Get toolName
   * @return toolName
  **/
  @ApiModelProperty(example = "ProtVista", value = "")

  public String getToolName() {
    return toolName;
  }

  public void setToolName(String toolName) {
    this.toolName = toolName;
  }

  public DataTool toolDescription(String toolDescription) {
    this.toolDescription = toolDescription;
    return this;
  }

  /**
   * Get toolDescription
   * @return toolDescription
  **/
  @ApiModelProperty(example = "Protein feature browser", value = "")

  public String getToolDescription() {
    return toolDescription;
  }

  public void setToolDescription(String toolDescription) {
    this.toolDescription = toolDescription;
  }

  public DataTool toolPreview(String toolPreview) {
    this.toolPreview = toolPreview;
    return this;
  }

  /**
   * Get toolPreview
   * @return toolPreview
  **/
  @ApiModelProperty(example = "http://toolregistry.intermine.org/protvista.png", value = "")

  public String getToolPreview() {
    return toolPreview;
  }

  public void setToolPreview(String toolPreview) {
    this.toolPreview = toolPreview;
  }

  public DataTool requiredClasses(List<String> requiredClasses) {
    this.requiredClasses = requiredClasses;
    return this;
  }

  public DataTool addRequiredClassesItem(String requiredClassesItem) {
    if (this.requiredClasses == null) {
      this.requiredClasses = new ArrayList<String>();
    }
    this.requiredClasses.add(requiredClassesItem);
    return this;
  }

  /**
   * Get requiredClasses
   * @return requiredClasses
  **/
  @ApiModelProperty(example = "[\"Gene\",\"Gene.homologues.homologue\"]", value = "")

  public List<String> getRequiredClasses() {
    return requiredClasses;
  }

  public void setRequiredClasses(List<String> requiredClasses) {
    this.requiredClasses = requiredClasses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataTool dataTool = (DataTool) o;
    return Objects.equals(this.toolId, dataTool.toolId) &&
        Objects.equals(this.toolName, dataTool.toolName) &&
        Objects.equals(this.toolDescription, dataTool.toolDescription) &&
        Objects.equals(this.toolPreview, dataTool.toolPreview) &&
        Objects.equals(this.requiredClasses, dataTool.requiredClasses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(toolId, toolName, toolDescription, toolPreview, requiredClasses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataTool {\n");
    
    sb.append("    toolId: ").append(toIndentedString(toolId)).append("\n");
    sb.append("    toolName: ").append(toIndentedString(toolName)).append("\n");
    sb.append("    toolDescription: ").append(toIndentedString(toolDescription)).append("\n");
    sb.append("    toolPreview: ").append(toIndentedString(toolPreview)).append("\n");
    sb.append("    requiredClasses: ").append(toIndentedString(requiredClasses)).append("\n");
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
