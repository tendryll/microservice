package com.hilton.soa.model;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Resource {
  private Integer id;

  @NotEmpty(message = "Name is not provided.")
  private String name;
  private String description;

  public Resource() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final Resource resource = (Resource) obj;
    return Objects.equals(id, resource.id) &&
        Objects.equals(name, resource.name) &&
        Objects.equals(description, resource.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }
}
