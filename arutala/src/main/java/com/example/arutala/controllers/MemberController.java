package com.example.arutala.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.arutala.models.Member;
import com.example.arutala.repositories.MemberRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/member")
public class MemberController {
  @Autowired
  MemberRepository memberRepo;

  // API Create
  @PostMapping("/create")
  public ResponseEntity<Object> createMember(@Valid @RequestBody Member body) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Create Member Sukses.";
    HttpStatus status = HttpStatus.CREATED;

    try {
      // Menambahkan data, menggunakan metho save() yang ada repository
      Member memberEntity = memberRepo.save(body);
      result.put("status", status);
      result.put("message", message);
      result.put("data", memberEntity);
    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e.getCause().getCause().getLocalizedMessage());
    }

    return ResponseEntity.status(status).body(result);
  }
}
