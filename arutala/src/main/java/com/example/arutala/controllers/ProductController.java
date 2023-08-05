package com.example.arutala.controllers;

import java.util.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.arutala.dtos.ProductDTO;
import com.example.arutala.models.Product;
import com.example.arutala.repositories.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
  @Autowired
  ProductRepository productRepo;

  ModelMapper mapper = new ModelMapper();

  @PostMapping("/create")
  public ResponseEntity<Object> createProduct(@Valid @RequestBody Product body) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Create Member Sukses.";
    HttpStatus status = HttpStatus.CREATED;

    try {
      // Menambahkan data, menggunakan metho save() yang ada repository
      Product product = productRepo.save(body);
      result.put("status", status);
      result.put("message", message);
      result.put("data", product);

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
      List<Product> listAll = productRepo.findAll();
      List<ProductDTO> listDto = new ArrayList<ProductDTO>();

      // mapping dari entity ke dto
      for (Product product : listAll) {
        ProductDTO dto = mapper.map(product, ProductDTO.class);

        // dto.setProductId(product.getProductId());
        // dto.setProductName(product.getProductName());
        // dto.setUnitOfStock(product.getUnitOfStock());
        // dto.setUnitPrice(product.getUnitPrice());
        //
        // CategoryDTO categoryDto = new CategoryDTO();
        // categoryDto.setCategoryId(product.getCategory().getCategoryId());
        // categoryDto.setDescription(product.getCategory().getDescription());
        // categoryDto.setName(product.getCategory().getName());
        // categoryDto.setCreatedAt(product.getCategory().getCreatedAt());
        // categoryDto.setUpdatedAt(product.getCategory().getUpdatedAt());

        // dto.setCategory(categoryDto);

        listDto.add(dto);
      }

      result.put("status", status);
      result.put("message", message);
      result.put("data", listDto);

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
  public ResponseEntity<Object> readProductById(@RequestParam(name = "productId") Long productId) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Read data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // read product dari database
      Product productEntity = productRepo.findById(productId).orElse(null);

      if (productEntity == null) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Product Id " + productId + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", productEntity);

        return ResponseEntity.status(status).body(result);
      }

      result.put("status", status);
      result.put("message", message);
      result.put("data", productEntity);
    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e);
    }

    return ResponseEntity.status(status).body(result);
  }

  // API Update
  @PostMapping("/update")
  public ResponseEntity<Object> updateProduct(@RequestParam(name = "productId") Long productId,
      @RequestBody Product body) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Update Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data product dari Database
      Product productEntity = productRepo.findById(productId).orElse(null);

      if (productEntity == null) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Product Id " + productId + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", productEntity);

        return ResponseEntity.status(status).body(result);
      }

      productEntity.setProductName(body.getProductName());
      productEntity.setUnitPrice(body.getUnitPrice());

      // update data product ke database
      productRepo.save(productEntity);

      result.put("status", status);
      result.put("message", message);
      result.put("data", productEntity);

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Update Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e);
    }

    return ResponseEntity.status(status).body(result);
  }

  // API Delete product by Id
  @PostMapping("/delete")
  public ResponseEntity<Object> deleteProductById(@RequestParam(name = "productId") Long productId) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Delete data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data product dari Database
      Product productEntity = productRepo.findById(productId).orElse(null);

      if (productEntity == null) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Product Id " + productId + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", productEntity);

        return ResponseEntity.status(status).body(result);
      }

      // delete data
      productRepo.delete(productEntity);

      result.put("status", status);
      result.put("message", message);
      result.put("data", productEntity);

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e);
    }

    return ResponseEntity.status(status).body(result);
  }

  // Read API by product name
  @GetMapping("/name")
  public ResponseEntity<Object> readProductByName(@RequestParam(name = "productName") String productName) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Read data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data product dari Database
      List<Product> listAll = productRepo.findByProductNameContaining(productName);
      List<ProductDTO> listDto = new ArrayList<ProductDTO>();

      // mapping dari entity ke dto
      for (Product product : listAll) {
        ProductDTO dto = mapper.map(product, ProductDTO.class);

        listDto.add(dto);
      }

      result.put("status", status);
      result.put("message", message);
      result.put("data", listDto);

      return ResponseEntity.status(status).body(result);

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
