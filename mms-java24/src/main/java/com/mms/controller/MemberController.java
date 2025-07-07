package com.mms.controller;

import com.mms.entity.Member;
import com.mms.exception.MemberNotFoundException;
import com.mms.service.MemberService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    private final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    public MemberController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String listMembers(Model model){
        LOGGER.info("Inside listMembers of MemberController");
        model.addAttribute("members", memberService.getAllMembers());
        return "members";
    }

    @GetMapping("/members/new")
    public String createMemberForm(Model model){
        Member member = new Member();
        model.addAttribute("member", member);
        return "create_member";
    }

    @PostMapping("/members")
    public String saveMember(@Valid @ModelAttribute("member") Member member){
        LOGGER.info("Inside saveMember of MemberController");
        memberService.saveMember(member);
        return "redirect:/members";
    }

    @GetMapping("/members/edit/{id}")
    public String editMemberForm(@PathVariable("id") Long id, Model model) throws MemberNotFoundException {
        model.addAttribute("member", memberService.getMemberById(id));
        return "edit_member";
    }

    @PostMapping("/members/{id}")
    public String updateMember(@PathVariable("id") Long id, @ModelAttribute("member") Member member, Model model) throws MemberNotFoundException {
        Member existingMember = memberService.getMemberById(id);
        existingMember.setId(id);
        existingMember.setFirstname(member.getFirstname());
        existingMember.setLastname(member.getLastname());
        existingMember.setPhone(member.getPhone());
        existingMember.setEmail(member.getEmail());

        memberService.updateMember(existingMember);
        return "redirect:/members";
    }

    @GetMapping("members/{id}")
    public String deleteMember(@PathVariable("id") Long id){
        memberService.deleteMemberById(id);
        return "redirect:/members";
    }

    @GetMapping("members/firstname/{firstname}")
    @ResponseBody
    public List<Member> getMemberByFirstName(@PathVariable("firstname") String firstname){
        return memberService.getMemberByFirstName(firstname);
    }

    @GetMapping("members/phone/{phone}")
    @ResponseBody
    public Member getMemberByPhone(@PathVariable("phone") String phone){
        return memberService.getMemberByPhone(phone);
    }

}
