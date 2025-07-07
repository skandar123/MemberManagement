package com.mms.repository;

import com.mms.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Member member = Member.builder()
                .firstname("Amar")
                .lastname("Singh")
                .phone("9123456789")
                .email("amar.singh@gmail.com")
                .build();

        entityManager.persist(member);
    }

    @Test
    public void isValidId(){
        Member member = memberRepository.findById(1L).orElseThrow();
        assertEquals("Amar", member.getFirstname());
    }
}