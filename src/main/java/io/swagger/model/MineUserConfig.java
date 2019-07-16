package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFileProperties;
import io.swagger.model.DataTool;
import io.swagger.model.MineDescriptor;
import io.swagger.model.SupplementaryDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MineUserConfig
 */
@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("MineUserConfig")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-11T16:42:11.071Z[GMT]")
public class MineUserConfig   {
  @JsonProperty("mineId")
  @Id
  private UUID mineId = null;

  @JsonProperty("userId")
  private UUID userId = null;

  @JsonProperty("mineDescriptor")
  private MineDescriptor mineDescriptor = null;

  @JsonProperty("dataTools")
  @Valid
  private List<DataTool> dataTools = null;

  @JsonProperty("supplementaryDataSources")
  @Valid
  private List<SupplementaryDataSource> supplementaryDataSources = null;

  @JsonProperty("dataFiles")
  @Valid
  private List<DataFileProperties> dataFiles = null;

  public MineUserConfig mineId(UUID mineId) {
    this.mineId = mineId;
    return this;
  }

  /**
   * Get mineId
   * @return mineId
  **/
  @ApiModelProperty(example = "03641b4d-bd7e-402f-803a-7aaf55c17238", value = "")

  @Valid
  public UUID getMineId() {
    return mineId;
  }

  public void setMineId(UUID mineId) {
    this.mineId = mineId;
  }

  public MineUserConfig userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(example = "549719c2-9b23-4e91-886d-cdb0250eeb09", value = "")

  @Valid
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public MineUserConfig mineDescriptor(MineDescriptor mineDescriptor) {
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

  public MineUserConfig dataTools(List<DataTool> dataTools) {
    this.dataTools = dataTools;
    return this;
  }

  public MineUserConfig addDataToolsItem(DataTool dataToolsItem) {
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

  public MineUserConfig supplementaryDataSources(List<SupplementaryDataSource> supplementaryDataSources) {
    this.supplementaryDataSources = supplementaryDataSources;
    return this;
  }

  public MineUserConfig addSupplementaryDataSourcesItem(SupplementaryDataSource supplementaryDataSourcesItem) {
    if (this.supplementaryDataSources == null) {
      this.supplementaryDataSources = new ArrayList<SupplementaryDataSource>();
    }
    this.supplementaryDataSources.add(supplementaryDataSourcesItem);
    return this;
  }

  /**
   * Get supplementaryDataSources
   * @return supplementaryDataSources
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<SupplementaryDataSource> getSupplementaryDataSources() {
    return supplementaryDataSources;
  }

  public void setSupplementaryDataSources(List<SupplementaryDataSource> supplementaryDataSources) {
    this.supplementaryDataSources = supplementaryDataSources;
  }

  public MineUserConfig dataFiles(List<DataFileProperties> dataFiles) {
    this.dataFiles = dataFiles;
    return this;
  }

  public MineUserConfig addDataFilesItem(DataFileProperties dataFilesItem) {
    if (this.dataFiles == null) {
      this.dataFiles = new ArrayList<DataFileProperties>();
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
  public List<DataFileProperties> getDataFiles() {
    return dataFiles;
  }

  public void setDataFiles(List<DataFileProperties> dataFiles) {
    this.dataFiles = dataFiles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MineUserConfig mineUserConfig = (MineUserConfig) o;
    return Objects.equals(this.mineId, mineUserConfig.mineId) &&
        Objects.equals(this.userId, mineUserConfig.userId) &&
        Objects.equals(this.mineDescriptor, mineUserConfig.mineDescriptor) &&
        Objects.equals(this.dataTools, mineUserConfig.dataTools) &&
        Objects.equals(this.supplementaryDataSources, mineUserConfig.supplementaryDataSources) &&
        Objects.equals(this.dataFiles, mineUserConfig.dataFiles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mineId, userId, mineDescriptor, dataTools, supplementaryDataSources, dataFiles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MineUserConfig {\n");
    
    sb.append("    mineId: ").append(toIndentedString(mineId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    mineDescriptor: ").append(toIndentedString(mineDescriptor)).append("\n");
    sb.append("    dataTools: ").append(toIndentedString(dataTools)).append("\n");
    sb.append("    supplementaryDataSources: ").append(toIndentedString(supplementaryDataSources)).append("\n");
    sb.append("    dataFiles: ").append(toIndentedString(dataFiles)).append("\n");
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
