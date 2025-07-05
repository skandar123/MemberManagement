package com.mms.service;

import com.mms.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMembers();
    Member saveMember(Member member);
    Member getMemberById(Long id);
    Member updateMember(Member member);
    void deleteMemberById(Long id);
}
