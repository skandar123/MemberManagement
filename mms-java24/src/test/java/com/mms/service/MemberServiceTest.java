package com.mms.service;

import com.mms.entity.Member;
import com.mms.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @MockitoBean
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        Member member=Member.builder()
                .firstname("Riya")
                .lastname("Nayak")
                .phone("8877654321")
                .email("riya.nayak@gmail.com")
                .build();

        Member member2 = Member.builder()
                .firstname("Riya")
                .lastname("Sharma")
                .phone("9988776655")
                .email("riya.sharma@gmail.com")
                .build();

        List<Member> members = Arrays.asList(member, member2);
        Mockito.when(memberRepository.findByFirstname("Riya")).thenReturn(members);
        Mockito.when(memberRepository.findByPhone("8877654321")).thenReturn(member);
    }

    @Test
    @DisplayName("Get members' data by their first name")
    public void isFirstNameValid() {
        String firstname = "Riya";
        List<Member> foundMembers = memberService.getMemberByFirstName(firstname);

        assertNotNull(foundMembers);
        assertFalse(foundMembers.isEmpty());
        assertEquals(2, foundMembers.size());
        assertTrue(foundMembers.stream().allMatch(m -> firstname.equals(m.getFirstname())));
    }

    @Test
    @DisplayName("Get a member's data by their phone")
    public void isPhoneValid(){
        String phone="8877654321";
        Member found=memberService.getMemberByPhone(phone);
        assertEquals(phone, found.getPhone());
    }
}