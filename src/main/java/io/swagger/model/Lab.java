package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.LabUsers;
import io.swagger.model.MineConfig;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Lab
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-16T10:40:16.301Z[GMT]")

public class Lab   {
  @JsonProperty("subdomain")
  private String subdomain = null;

  @JsonProperty("mines")
  @Valid
  private List<MineConfig> mines = null;

  @JsonProperty("users")
  private LabUsers users = null;

  public Lab subdomain(String subdomain) {
    this.subdomain = subdomain;
    return this;
  }

  /**
   * Get subdomain
   * @return subdomain
  **/
  @ApiModelProperty(example = "AliceLab", required = true, value = "")
  @NotNull


  public String getSubdomain() {
    return subdomain;
  }

  public void setSubdomain(String subdomain) {
    this.subdomain = subdomain;
  }

  public Lab mines(List<MineConfig> mines) {
    this.mines = mines;
    return this;
  }

  public Lab addMinesItem(MineConfig minesItem) {
    if (this.mines == null) {
      this.mines = new ArrayList<MineConfig>();
    }
    this.mines.add(minesItem);
    return this;
  }

  /**
   * Get mines
   * @return mines
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<MineConfig> getMines() {
    return mines;
  }

  public void setMines(List<MineConfig> mines) {
    this.mines = mines;
  }

  public Lab users(LabUsers users) {
    this.users = users;
    return this;
  }

  /**
   * Get users
   * @return users
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public LabUsers getUsers() {
    return users;
  }

  public void setUsers(LabUsers users) {
    this.users = users;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lab lab = (Lab) o;
    return Objects.equals(this.subdomain, lab.subdomain) &&
        Objects.equals(this.mines, lab.mines) &&
        Objects.equals(this.users, lab.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subdomain, mines, users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lab {\n");
    
    sb.append("    subdomain: ").append(toIndentedString(subdomain)).append("\n");
    sb.append("    mines: ").append(toIndentedString(mines)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
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

