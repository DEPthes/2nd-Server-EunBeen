package api;

import domain.Member;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
//@Controller , @ResponseBody를 포함한 @RestController
@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private  final  MemberService memberService;

//    @Valid 어노테이션이 작동이 안 한다면?
//    spring boot 2.3 version 이상부터는 spring-boot-starter-web 의존성 내부에 있던 validation이 사라졌습니다.
//    때문에 사용하시는 spring boot version이 2.3 이상이라면 validation 의존성을 따로 추가해주셔야 사용할 수 있습니다.

//    Validation을 사용하기 위해 먼저 의존성을 추가.

    @PostMapping("/api/v1/members") //등록이니까
    public  CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberResponse{
        private Long id;

        public CreateMemberResponse(Long id){
            this.id=id;
        }
    }

}
