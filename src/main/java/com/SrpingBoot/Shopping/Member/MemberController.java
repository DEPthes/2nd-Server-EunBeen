package com.SrpingBoot.Shopping.Member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


//@Controller , @ResponseBody를 포함한 @RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")

public class MemberController {

    private final MemberService memberService;

    // api 요청 스펙을 위한 별도의 DTO를 만들고 파라미터로 받아야 합니다.
    //회원 등록 api
    @GetMapping("")
    public String memberIndex() {
        return "members/index";
    }

    @GetMapping("/new")
    public String getMember(Model model) {
        model.addAttribute("createForm", new MemberDto.CreateMemberRequest());
        return "members/createForm";
    }

    @PostMapping("/new")
    public String saveMember(@ModelAttribute("createForm") @Valid MemberDto.CreateMemberRequest request, Model model) {
        Long id = memberService.join(request);
        Optional<Member> member=memberService.findById(id);
        model.addAttribute("member", member.get());
        return "members/createResult";
    }

    @GetMapping("/list")
    public String askMemberId(Model model) {
        model.addAttribute("memberId", null);
        return "members/findForm";
    }

    @PostMapping("/list")
    public String findMemberId(@RequestParam("id") Long id, Model model) {
        Optional<Member> member = memberService.findById(id);

        if (member.isPresent()) {
            model.addAttribute("memberId", id);
            model.addAttribute("member", member.get());
            return "members/findResult";
        } else {
            return "redirect:/members/list";
        }
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/allMembers";
    }

    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        Optional<Member> member = memberService.findById(id);
        model.addAttribute("member", member.get());

        return "members/updateForm";
    }

    @PostMapping("/edit")
    public String updateMember(@RequestParam("id") Long id,
                               @RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {

        Optional<Member> member = memberService.findById(id);

        if (member.isPresent()) {
            Member existingMember = member.get();
            existingMember.updateMember(name, email, password);
            memberService.update(existingMember);

            String message = "회원 정보가 업데이트되었습니다.";
            model.addAttribute("message", message);
            model.addAttribute("member", existingMember);

            return "members/updateResult";
        } else {
            String message = "존재하지 않는 회원 정보입니다.";
            model.addAttribute("message", message);

            return "members/updateResult";
        }
    }

    @GetMapping("/exit")
    public String askDeleteId(Model model) {
        model.addAttribute("memberId", null);
        return "members/deleteForm";
    }

    @PostMapping("/exit")
    public String deleteMember(@RequestParam("id") Long id, Model model) {
        Optional<Member> member = memberService.findById(id);

        if (member.isPresent()) {
            memberService.deleteById(id);
            String message = "회원 탈퇴가 완료되었습니다.";
            model.addAttribute("message", message);
        } else {
            String message = "존재하지 않는 회원 정보입니다.";
            model.addAttribute("message", message);
        }
        return "members/deleteResult";
    }





}


