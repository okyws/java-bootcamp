package com.example.arutala.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;

  @Column(nullable = false)
  private String productName;

  @Column()
  private double unitPrice;
  @Column()
  private int unitOfStock;

  @ManyToOne
  @JoinColumn(name = "categoryId", nullable = false)
  private Category category;

  public Product() {
    super();
  }

  public Product(Long productId, String productName, double unitPrice, int unitOfStock, Category category) {
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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

}
