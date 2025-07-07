package com.mms.controller;

import com.mms.entity.Member;
import com.mms.exception.MemberNotFoundException;
import com.mms.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MemberService memberService;

    private Member member;

    @BeforeEach
    void setUp() {
        member = Member.builder()
                .firstname("Suman")
                .lastname("Joshi")
                .phone("8899776655")
                .email("suman.joshi@gmail.com")
                .build();
    }

    @Test
    void saveMember() throws Exception {
        Member inputMember = Member.builder()
                .firstname("Suman")
                .lastname("Joshi")
                .phone("8899776655")
                .email("suman.joshi@gmail.com")
                .build();

        Mockito.when(memberService.saveMember(inputMember)).thenReturn(member);

        mockMvc.perform(post("/members")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON_UTF_8))
                        .param("firstname", "Suman")
                        .param("lastname", "Joshi")
                        .param("phone", "8899776655")
                        .param("email", "suman.joshi@gmail.com"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void editMemberForm() throws Exception {
        Mockito.when(memberService.getMemberById(1L)).thenReturn(member);

        mockMvc.perform(get("/members/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit_member"))
                .andExpect(model().attributeExists("member"))
                .andExpect(model().attribute("member", org.hamcrest.Matchers.hasProperty("firstname", org.hamcrest.Matchers.is("Suman"))));
    }
}