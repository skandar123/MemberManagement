package com.mms.service;

import com.mms.entity.Member;
import com.mms.exception.MemberNotFoundException;

import java.util.List;

public interface MemberService {
    List<Member> getAllMembers();
    Member saveMember(Member member);
    Member getMemberById(Long id) throws MemberNotFoundException;
    Member updateMember(Member member);
    void deleteMemberById(Long id);
    List<Member> getMemberByFirstName(String firstname);
    Member getMemberByPhone(String phone);
}
