package com.example.arutala.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.example.arutala.models.Member;
import com.example.arutala.repositories.MemberRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/member")
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

  // API Read All Member Data
  @GetMapping("/")
  public ResponseEntity<Object> readAllMember() {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Read data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      List<Member> listAllMember = memberRepo.findAll();

      result.put("status", status);
      result.put("message", message);
      result.put("data", listAllMember);

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e);
    }

    return ResponseEntity.status(status).body(result);
  }

  // API Read member by Id
  @GetMapping("/id")
  public ResponseEntity<Object> readMemberById(@RequestParam(name = "memberId") Long memberId) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Read data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      Member memberEntity = memberRepo.findById(memberId).orElse(null);

      if (memberEntity == null) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Member Id " + memberId + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", memberEntity);

        return ResponseEntity.status(status).body(result);
      }

      result.put("status", status);
      result.put("message", message);
      result.put("data", memberEntity);

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
  @PutMapping("/update")
  public ResponseEntity<Object> updateMember(@RequestParam(name = "memberId") Long memberId, @RequestBody Member body) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Update Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      Member memberEntity = memberRepo.findById(memberId).orElse(null);

      if (memberEntity == null) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Member Id " + memberId + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", memberEntity);

        return ResponseEntity.status(status).body(result);
      }

      memberEntity.setMemberName(body.getMemberName());
      memberEntity.setAddress(body.getAddress());

      // update ke database menggunakan method save() di repository
      memberRepo.save(memberEntity);

      result.put("status", status);
      result.put("message", message);
      result.put("data", memberEntity);

    } catch (Exception e) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Proses Create Error";
      result.put("status", status);
      result.put("message", message);
      result.put("error", e);
    }

    return ResponseEntity.status(status).body(result);
  }

  // API Delete member by Id
  @DeleteMapping("/delete")
  public ResponseEntity<Object> deleteMemberById(@RequestParam(name = "memberId") Long memberId) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Delete data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      Member memberEntity = memberRepo.findById(memberId).orElse(null);

      if (memberEntity == null) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Member Id " + memberId + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", memberEntity);

        return ResponseEntity.status(status).body(result);
      }

      // delete data
      memberRepo.delete(memberEntity);

      result.put("status", status);
      result.put("message", message);
      result.put("data", memberEntity);

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
  public ResponseEntity<Object> readMemberById(@RequestParam(name = "memberName") String memberName) {
    Map<String, Object> result = new HashMap<String, Object>();
    String message = "Read data Sukses.";
    HttpStatus status = HttpStatus.OK;

    try {
      // Read data member dari Database
      List<Member> memberEntity = memberRepo.findByMemberNameContaining(memberName);

      if (memberEntity.isEmpty()) {
        status = HttpStatus.NOT_FOUND;
        message = "Data dengan Member Name " + memberName + " tidak ditemukan.";

        result.put("status", status);
        result.put("message", message);
        result.put("data", memberEntity);

        return ResponseEntity.status(status).body(result);
      }

      result.put("status", status);
      result.put("message", message);
      result.put("data", memberEntity);

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
