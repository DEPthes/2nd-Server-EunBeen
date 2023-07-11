package com.SrpingBoot.Shopping.Member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class MemberDto {
    @Data
    public static class CreateMemberRequest {
        private String name;
        private String password;
        private String email;
        private int point;
    }

    @Data

    public static class MemberResponse {
        private Long id;
        private String name;
        private String email;
        private int point;
    }

}
