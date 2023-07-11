package com.SrpingBoot.Shopping.Member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dto {
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
