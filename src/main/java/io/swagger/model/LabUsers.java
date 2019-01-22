package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LabUsers
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-01-16T10:40:16.301Z[GMT]")

public class LabUsers   {
  @JsonProperty("Owners")
  @Valid
  private List<User> owners = null;

  @JsonProperty("Admins")
  @Valid
  private List<User> admins = null;

  @JsonProperty("Viewers")
  @Valid
  private List<User> viewers = null;

  public LabUsers owners(List<User> owners) {
    this.owners = owners;
    return this;
  }

  public LabUsers addOwnersItem(User ownersItem) {
    if (this.owners == null) {
      this.owners = new ArrayList<User>();
    }
    this.owners.add(ownersItem);
    return this;
  }

  /**
   * Get owners
   * @return owners
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<User> getOwners() {
    return owners;
  }

  public void setOwners(List<User> owners) {
    this.owners = owners;
  }

  public LabUsers admins(List<User> admins) {
    this.admins = admins;
    return this;
  }

  public LabUsers addAdminsItem(User adminsItem) {
    if (this.admins == null) {
      this.admins = new ArrayList<User>();
    }
    this.admins.add(adminsItem);
    return this;
  }

  /**
   * Get admins
   * @return admins
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<User> getAdmins() {
    return admins;
  }

  public void setAdmins(List<User> admins) {
    this.admins = admins;
  }

  public LabUsers viewers(List<User> viewers) {
    this.viewers = viewers;
    return this;
  }

  public LabUsers addViewersItem(User viewersItem) {
    if (this.viewers == null) {
      this.viewers = new ArrayList<User>();
    }
    this.viewers.add(viewersItem);
    return this;
  }

  /**
   * Get viewers
   * @return viewers
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<User> getViewers() {
    return viewers;
  }

  public void setViewers(List<User> viewers) {
    this.viewers = viewers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LabUsers labUsers = (LabUsers) o;
    return Objects.equals(this.owners, labUsers.owners) &&
        Objects.equals(this.admins, labUsers.admins) &&
        Objects.equals(this.viewers, labUsers.viewers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owners, admins, viewers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LabUsers {\n");
    
    sb.append("    owners: ").append(toIndentedString(owners)).append("\n");
    sb.append("    admins: ").append(toIndentedString(admins)).append("\n");
    sb.append("    viewers: ").append(toIndentedString(viewers)).append("\n");
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

