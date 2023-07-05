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
