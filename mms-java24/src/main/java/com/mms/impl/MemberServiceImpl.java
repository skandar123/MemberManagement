package com.mms.impl;

import com.mms.entity.Member;
import com.mms.repository.MemberRepository;
import com.mms.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        super();
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }
}
