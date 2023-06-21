package DEPth_SpringBasic.DEPth_SpringBasic.controller;

import DEPth_SpringBasic.DEPth_SpringBasic.Service.MemberService;
import DEPth_SpringBasic.DEPth_SpringBasic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//@Controller -> MemberController 객체를 생성해서 Spring에 넣어두게 되고, 이를 Spring이 관리하게 됨.
//==Spring Container에서 Spring Bean이 관리된다.
public class MemberController {
    private final MemberService memberService;
    @Autowired
    //@Autoweired->memberService를 Spring이 Spring Container 내의 memberService와 연결시켜 줌.
    //MemberService에 @Service가 존재해야 가능 +@Repository도 필요
    //DI (스프링-스프링빈 의존관계 그림 참고)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
