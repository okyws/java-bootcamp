package com.example.arutala.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.arutala.dtos.CategoryDTO;
import com.example.arutala.models.Category;
import com.example.arutala.repositories.CategoryRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
  @Autowired
  CategoryRepository categoryRepo;

  ModelMapper mapper = new ModelMapper();

  @PostMapping("/create")
  public ResponseEntity<Object> createCategory(@Valid @RequestBody Category body) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Create Member Sukses.";
    HttpStatus status = HttpStatus.CREATED;

    try {
      // Menambahkan data, menggunakan metho save() yang ada repository
      Category category = categoryRepo.save(body);
      result.put("status", status);
      result.put("message", message);
      result.put("data", category);

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e.getCause().getCause().getLocalizedMessage());
    }

    return ResponseEntity.status(status).body(result);

  }

  @GetMapping("/readall")
  public ResponseEntity<Object> readAll() {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Read data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      List<Category> listAllMember = categoryRepo.findAll();
      List<CategoryDTO> listAllDto = new ArrayList<CategoryDTO>();

      // Mapping data dari entity ke DTO
      for (Category entity : listAllMember) {
        CategoryDTO dto = mapper.map(entity, CategoryDTO.class);

        // dto.setCategoryId(entity.getCategoryId());
        // dto.setName(entity.getName());
        // dto.setCreatedAt(entity.getCreatedAt());
        // dto.setDescription(entity.getDescription());
        // dto.setUpdatedAt(entity.getUpdatedAt());

        listAllDto.add(dto);
      }

      result.put("status", status);
      result.put("message", message);
      result.put("data", listAllDto);// dimasukan ke map sebagai body response API

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e);
    }

    return ResponseEntity.status(status).body(result);
  }

  // API Read Category by Id
  @GetMapping("/id")
  public ResponseEntity<Object> readCategoryById(@RequestParam(name = "categoryId") Long categoryId) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Read data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      Category categoryEntity = categoryRepo.findById(categoryId).orElse(null);

      if (categoryId == null) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Category Id " + categoryId + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", categoryEntity);

        return ResponseEntity.status(status).body(result);
      }

      result.put("status", status);
      result.put("message", message);
      result.put("data", categoryEntity);

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e.getMessage());
    }

    return ResponseEntity.status(status).body(result);
  }

  // API Update
  @PutMapping("/update")
  public ResponseEntity<Object> updateCategory(@RequestParam(name = "categoryId") Long categoryId,
      @RequestBody Category body) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Update Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      Category categoryEntity = categoryRepo.findById(categoryId).orElse(null);

      if (categoryEntity == null) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Category Id " + categoryId + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", categoryEntity);

        return ResponseEntity.status(status).body(result);
      }

      categoryEntity.setName(body.getName());
      categoryEntity.setDescription(body.getDescription());

      // update ke database menggunakan method save() di repository
      categoryRepo.save(categoryEntity);

      result.put("status", status);
      result.put("message", message);
      result.put("data", categoryEntity);

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Update Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e);
    }

    return ResponseEntity.status(status).body(result);
  }

  // API Delete member by Id
  @DeleteMapping("/delete")
  public ResponseEntity<Object> deleteCategoryById(@RequestParam(name = "categoryId") Long categoryId) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Delete data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      Category categoryEntity = categoryRepo.findById(categoryId).orElse(null);

      if (categoryEntity == null) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Category Id " + categoryId + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", categoryEntity);

        return ResponseEntity.status(status).body(result);
      }

      // delete data
      categoryRepo.delete(categoryEntity);

      result.put("status", status);
      result.put("message", message);
      result.put("data", categoryEntity);

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e);
    }

    return ResponseEntity.status(status).body(result);
  }

  // Read API by member name
  @GetMapping("/byname")
  public ResponseEntity<Object> readCategoryById(@RequestParam(name = "categoryName") String categoryName) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Read data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      List<Category> categoryEntity = categoryRepo.findByNameContaining(categoryName);

      if (categoryEntity.isEmpty()) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Category Name " + categoryName + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", categoryName);

        return ResponseEntity.status(status).body(result);
      }

      result.put("status", status);
      result.put("message", message);
      result.put("data", categoryEntity);

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e);
    }

    return ResponseEntity.status(status).body(result);
  }
}
