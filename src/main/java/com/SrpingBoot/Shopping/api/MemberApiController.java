package com.SrpingBoot.Shopping.api;

import com.SrpingBoot.Shopping.domain.Member;
import com.SrpingBoot.Shopping.service.MemberService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller , @ResponseBody를 포함한 @RestController
@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private  final  MemberService memberService;

    @PostMapping("/api/v1/members") //등록-> @PostMapping 사용
    public  CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
        if (member.getName() == null || member.getName().isEmpty()) {
            throw new Exceptions.InvalidRequestException("Invalid user name");
        }

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberResponse{

        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

}