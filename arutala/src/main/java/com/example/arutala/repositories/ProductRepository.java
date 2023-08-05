package com.example.arutala.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.arutala.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByProductNameContaining(String name);
}
