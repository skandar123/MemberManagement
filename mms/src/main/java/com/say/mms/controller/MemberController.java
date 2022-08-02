package com.say.mms.controller;

import com.say.mms.entity.Member;
import com.say.mms.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String listMembers(Model model){
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
    public String saveMember(@ModelAttribute("member") Member member){
        memberService.saveMember(member);
        return "redirect:/members";
    }

    @GetMapping("/members/edit/{id}")
    public String editMemberForm(@PathVariable Long id, Model model){
        model.addAttribute("member", memberService.getMemberById(id));
        return "edit_member";
    }

    @PostMapping("/members/{id}")
    public String updateMember(@PathVariable Long id, @ModelAttribute("member") Member member, Model model){
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
    public String deleteMember(@PathVariable Long id){
        memberService.deleteMemberById(id);
        return "redirect:/members";
    }
}
