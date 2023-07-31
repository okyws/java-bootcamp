package com.example.arutala.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.arutala.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

  List<Member> findByMemberNameContaining(String name);

}
