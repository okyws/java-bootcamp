package com.example.arutala.dtos;

import java.util.Date;

public class CategoryDTO {
  private Long categoryId;
  private String name;
  private String description;
  private Date createdAt;
  private Date updatedAt;

  public CategoryDTO() {
    super();
  }

  public CategoryDTO(Long categoryId, String description, Date createdAt, Date updatedAt, String name) {
    super();
    this.categoryId = categoryId;
    this.name = name;
    this.description = description;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
