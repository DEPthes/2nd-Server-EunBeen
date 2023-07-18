package com.SrpingBoot.Shopping.Member;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MemberDto {

    private Long id;
    private String name;
    private String password;
    private String email;
    private int point;

    @Data
    static class CreateMemberRequest{
        @NotEmpty
        private String name;
        @NotEmpty
        private String password;
        @NotEmpty
        private String email;
    }

    @Data
    static class CreateMemberResponse {
        private Long id;
        private int point;

        public CreateMemberResponse(Long id) {
            this.id = id;
            this.point = 0;
        }
    }

}
