package com.example.arutala.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.arutala.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  List<Category> findByNameContaining(String name);
}
