package com.SrpingBoot.Shopping.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Controller , @ResponseBody를 포함한 @RestController
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final MemberService memberService;


    // api 요청 스펙을 위한 별도의 DTO를 만들고 파라미터로 받아야 합니다.
    //회원 등록 api
    @PostMapping("/api/members")
    public MemberDto.CreateMemberResponse saveMember(@RequestBody @Valid MemberDto.CreateMemberRequest request){
        MemberDto member=new MemberDto();
        Long id=memberService.join(member);
        member=MemberDto.builder()
                        .id(id)
                        .name(request.getName())
                        .password(request.getPassword())
                        .email(request.getEmail())
                        .build();


        return new MemberDto.CreateMemberResponse(id);
    }

//    @GetMapping("/api/members/{id}")
//    public ResponseEntity<MemberDto.CreateMemberResponse> getMember(@PathVariable Long id) {
//        Member member = MemberService.getMemberById(id);
//        if (member == null) {
//            return ResponseEntity.notFound().build();
//        }
//        MemberDto.CreateMemberResponse response = new MemberDto.CreateMemberResponse(member.getId(), member.getName());
//        return ResponseEntity.ok(response);
//    }
}








//

