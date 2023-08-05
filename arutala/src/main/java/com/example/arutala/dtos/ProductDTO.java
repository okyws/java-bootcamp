package com.example.arutala.dtos;

public class ProductDTO {
  private Long productId;
  private String productName;
  private double unitPrice;
  private int unitOfStock;
  private CategoryDTO category;

  public ProductDTO() {
    super();
  }

  public ProductDTO(Long productId, String productName, double unitPrice, int unitOfStock, CategoryDTO category) {
    super();
    this.productId = productId;
    this.productName = productName;
    this.unitPrice = unitPrice;
    this.unitOfStock = unitOfStock;
    this.category = category;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public int getUnitOfStock() {
    return unitOfStock;
  }

  public void setUnitOfStock(int unitOfStock) {
    this.unitOfStock = unitOfStock;
  }

  public CategoryDTO getCategory() {
    return category;
  }

  public void setCategory(CategoryDTO category) {
    this.category = category;
  }

}
