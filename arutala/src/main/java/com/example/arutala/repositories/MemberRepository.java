package com.example.arutala.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.arutala.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
