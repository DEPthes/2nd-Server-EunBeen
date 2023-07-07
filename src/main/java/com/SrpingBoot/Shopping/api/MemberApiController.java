package com.SrpingBoot.Shopping.api;

import com.SrpingBoot.Shopping.domain.Member;
import com.SrpingBoot.Shopping.dto.MemberDto;
import com.SrpingBoot.Shopping.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@Controller , @ResponseBody를 포함한 @RestController
@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private  final  MemberService memberService;
//좋지 않은 방법
    /*
    @PostMapping("/api/v1/members") //등록-> @PostMapping 사용
    public  CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
        if (member.getName() == null || member.getName().isEmpty()) {
            throw new Exceptions.InvalidRequestException("Invalid user name");
        }
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }
    */

//    ->별도의 Dto를 만들어서 Dto를 파라미터로 받아 사용하는 것이 좋다.
//    api 스펙을 위해서. 외부에서 변경할 위험이 있기 때문에
//    ---->v2가 그 예시
//    api를 만들 땐 Entity를 파라미터로 받지 말 것! + 외부에 노출해서도 안됨.

    @PostMapping("/api/create/members")
    public MemberDto.CreateMemberResponse saveMember(@RequestBody @Valid MemberDto.CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new MemberDto.CreateMemberResponse(id);
    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<MemberDto.GetMemberResponse> getMember(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        MemberDto.GetMemberResponse response = new MemberDto.GetMemberResponse(member.getId(), member.getName());
        return ResponseEntity.ok(response);
    }

}

