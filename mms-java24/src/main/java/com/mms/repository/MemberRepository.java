package com.mms.repository;

import com.mms.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findByFirstname(String firstname);
    public Member findByPhone(String phone);
}
