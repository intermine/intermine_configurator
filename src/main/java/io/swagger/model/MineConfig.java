package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFile;
import io.swagger.model.DataTool;
import io.swagger.model.MineDescriptor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MineConfig
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-30T13:08:33.831Z[GMT]")
public class MineConfig   {
  @JsonProperty("mineDescriptor")
  private MineDescriptor mineDescriptor = null;

  @JsonProperty("dataTools")
  @Valid
  private List<DataTool> dataTools = null;

  @JsonProperty("dataFiles")
  @Valid
  private List<DataFile> dataFiles = null;

  @JsonProperty("projectXML")
  private String projectXML = null;

  @JsonProperty("globalAdditions")
  private String globalAdditions = null;

  public MineConfig mineDescriptor(MineDescriptor mineDescriptor) {
    this.mineDescriptor = mineDescriptor;
    return this;
  }

  /**
   * Get mineDescriptor
   * @return mineDescriptor
  **/
  @ApiModelProperty(value = "")

  @Valid
  public MineDescriptor getMineDescriptor() {
    return mineDescriptor;
  }

  public void setMineDescriptor(MineDescriptor mineDescriptor) {
    this.mineDescriptor = mineDescriptor;
  }

  public MineConfig dataTools(List<DataTool> dataTools) {
    this.dataTools = dataTools;
    return this;
  }

  public MineConfig addDataToolsItem(DataTool dataToolsItem) {
    if (this.dataTools == null) {
      this.dataTools = new ArrayList<DataTool>();
    }
    this.dataTools.add(dataToolsItem);
    return this;
  }

  /**
   * Get dataTools
   * @return dataTools
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<DataTool> getDataTools() {
    return dataTools;
  }

  public void setDataTools(List<DataTool> dataTools) {
    this.dataTools = dataTools;
  }

  public MineConfig dataFiles(List<DataFile> dataFiles) {
    this.dataFiles = dataFiles;
    return this;
  }

  public MineConfig addDataFilesItem(DataFile dataFilesItem) {
    if (this.dataFiles == null) {
      this.dataFiles = new ArrayList<DataFile>();
    }
    this.dataFiles.add(dataFilesItem);
    return this;
  }

  /**
   * Get dataFiles
   * @return dataFiles
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<DataFile> getDataFiles() {
    return dataFiles;
  }

  public void setDataFiles(List<DataFile> dataFiles) {
    this.dataFiles = dataFiles;
  }

  public MineConfig projectXML(String projectXML) {
    this.projectXML = projectXML;
    return this;
  }

  /**
   * Get projectXML
   * @return projectXML
  **/
  @ApiModelProperty(value = "")

  public String getProjectXML() {
    return projectXML;
  }

  public void setProjectXML(String projectXML) {
    this.projectXML = projectXML;
  }

  public MineConfig globalAdditions(String globalAdditions) {
    this.globalAdditions = globalAdditions;
    return this;
  }

  /**
   * Get globalAdditions
   * @return globalAdditions
  **/
  @ApiModelProperty(value = "")

  public String getGlobalAdditions() {
    return globalAdditions;
  }

  public void setGlobalAdditions(String globalAdditions) {
    this.globalAdditions = globalAdditions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MineConfig mineConfig = (MineConfig) o;
    return Objects.equals(this.mineDescriptor, mineConfig.mineDescriptor) &&
        Objects.equals(this.dataTools, mineConfig.dataTools) &&
        Objects.equals(this.dataFiles, mineConfig.dataFiles) &&
        Objects.equals(this.projectXML, mineConfig.projectXML) &&
        Objects.equals(this.globalAdditions, mineConfig.globalAdditions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mineDescriptor, dataTools, dataFiles, projectXML, globalAdditions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MineConfig {\n");
    
    sb.append("    mineDescriptor: ").append(toIndentedString(mineDescriptor)).append("\n");
    sb.append("    dataTools: ").append(toIndentedString(dataTools)).append("\n");
    sb.append("    dataFiles: ").append(toIndentedString(dataFiles)).append("\n");
    sb.append("    projectXML: ").append(toIndentedString(projectXML)).append("\n");
    sb.append("    globalAdditions: ").append(toIndentedString(globalAdditions)).append("\n");
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
