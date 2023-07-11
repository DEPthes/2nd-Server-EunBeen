package com.SrpingBoot.Shopping.Member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Controller , @ResponseBody를 포함한 @RestController
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final Service service;

    @PostMapping("/api/members")
    public ResponseEntity<MemberDto.MemberResponse> saveMember(@RequestBody @Valid MemberDto.CreateMemberRequest request) {
        Member member = Member.builder()
                .name(request.getName())
                .password(request.getPassword())
                .email(request.getEmail())
                .point(request.getPoint())
                .build();

        Long id = service.join(member);

        MemberDto.MemberResponse response = MemberDto.MemberResponse.builder()
                .id(id)
                .name(member.getName())
                .email(member.getEmail())
                .point(member.getPoint())
                .build();

        return ResponseEntity.ok(response);
    }

//    @GetMapping("/api/members/{id}")
//    public ResponseEntity<Dto.GetMemberResponse> getMember(@PathVariable Long id) {
//        Member member = service.getMemberById(id);
//        if (member == null) {
//            return ResponseEntity.notFound().build();
//        }
//        Dto.GetMemberResponse response = new Dto.GetMemberResponse(member.getId(), member.getName());
//        return ResponseEntity.ok(response);
//    }


//    }
}
