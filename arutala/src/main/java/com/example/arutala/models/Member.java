package com.example.arutala.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member implements Serializable {
  private static final long serialVersionUID = -2343243243242432341L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  @Column(nullable = false)
  private String name;

  @Column()
  private String address;

  public Member() {
    super();
  }

  public Member(Long memberId, String name, String address) {
    super();
    this.memberId = memberId;
    this.name = name;
    this.address = address;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Long getMemberId() {
    return memberId;
  }

  public void setMemberId(Long memberId) {
    this.memberId = memberId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
