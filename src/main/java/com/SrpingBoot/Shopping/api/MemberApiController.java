package com.SrpingBoot.Shopping.api;

import com.SrpingBoot.Shopping.domain.Member;
import com.SrpingBoot.Shopping.exception.Exceptions;
import com.SrpingBoot.Shopping.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
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
//    ->별도의 Dto를 만들어서 dto를 파라미터로 받아 사용하는 것이 좋다.
//    api 스펙을 위해서. 외부에서 변경할 위험이 있기 때문에
//    ---->v2가 그 예시
//    api를 만들 땐 Entity를 파라미터로 받지 말 것! + 외부에 노출해서도 안됨.

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request){

        Member member=new Member();
        member.setName(request.getName());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberRequest{
        @NotEmpty
        private String name;
    }


    @Data
    static class CreateMemberResponse{

        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

}