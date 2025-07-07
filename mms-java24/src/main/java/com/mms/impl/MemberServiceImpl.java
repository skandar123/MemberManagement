package com.mms.impl;

import com.mms.entity.Member;
import com.mms.exception.MemberNotFoundException;
import com.mms.repository.MemberRepository;
import com.mms.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Member getMemberById(Long id) throws MemberNotFoundException {
        Optional<Member> member= memberRepository.findById(id);
        if(!member.isPresent())
            throw new MemberNotFoundException("Member not available");
        return member.get();
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<Member> getMemberByFirstName(String firstname) {
        return memberRepository.findByFirstname(firstname);
    }

    @Override
    public Member getMemberByPhone(String phone) {
        return memberRepository.findByPhone(phone);
    }
}
