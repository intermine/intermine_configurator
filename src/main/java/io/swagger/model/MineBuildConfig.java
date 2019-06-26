package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.MineDescriptor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MineBuildConfig
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-06-25T11:51:24.013Z[GMT]")
public class MineBuildConfig   {
  @JsonProperty("mineDescriptor")
  private MineDescriptor mineDescriptor = null;

  @JsonProperty("dataTools")
  @Valid
  private List<String> dataTools = new ArrayList<String>();

  @JsonProperty("projectXML")
  private String projectXML = null;

  @JsonProperty("globalAdditions")
  private String globalAdditions = null;

  public MineBuildConfig mineDescriptor(MineDescriptor mineDescriptor) {
    this.mineDescriptor = mineDescriptor;
    return this;
  }

  /**
   * Get mineDescriptor
   * @return mineDescriptor
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public MineDescriptor getMineDescriptor() {
    return mineDescriptor;
  }

  public void setMineDescriptor(MineDescriptor mineDescriptor) {
    this.mineDescriptor = mineDescriptor;
  }

  public MineBuildConfig dataTools(List<String> dataTools) {
    this.dataTools = dataTools;
    return this;
  }

  public MineBuildConfig addDataToolsItem(String dataToolsItem) {
    this.dataTools.add(dataToolsItem);
    return this;
  }

  /**
   * Get dataTools
   * @return dataTools
  **/
  @ApiModelProperty(example = "[\"@intermine/bluegenes-protvista@1.1.1\",\"@intermine/bluegenes-cytoscape-interaction-network-viewer@1.1.0\"]", required = true, value = "")
  @NotNull

  public List<String> getDataTools() {
    return dataTools;
  }

  public void setDataTools(List<String> dataTools) {
    this.dataTools = dataTools;
  }

  public MineBuildConfig projectXML(String projectXML) {
    this.projectXML = projectXML;
    return this;
  }

  /**
   * Get projectXML
   * @return projectXML
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getProjectXML() {
    return projectXML;
  }

  public void setProjectXML(String projectXML) {
    this.projectXML = projectXML;
  }

  public MineBuildConfig globalAdditions(String globalAdditions) {
    this.globalAdditions = globalAdditions;
    return this;
  }

  /**
   * Get globalAdditions
   * @return globalAdditions
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

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
    MineBuildConfig mineBuildConfig = (MineBuildConfig) o;
    return Objects.equals(this.mineDescriptor, mineBuildConfig.mineDescriptor) &&
        Objects.equals(this.dataTools, mineBuildConfig.dataTools) &&
        Objects.equals(this.projectXML, mineBuildConfig.projectXML) &&
        Objects.equals(this.globalAdditions, mineBuildConfig.globalAdditions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mineDescriptor, dataTools, projectXML, globalAdditions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MineBuildConfig {\n");
    
    sb.append("    mineDescriptor: ").append(toIndentedString(mineDescriptor)).append("\n");
    sb.append("    dataTools: ").append(toIndentedString(dataTools)).append("\n");
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
