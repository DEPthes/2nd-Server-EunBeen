package com.SrpingBoot.Shopping.dto;

import com.SrpingBoot.Shopping.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;

    @NotBlank(message = "이름을 입력해 주세요.")
    private String name;

    @Data
    public static class CreateMemberRequest {
        @NotEmpty
        private String name;
    }

    @Data
    public static class CreateMemberResponse {
        private Long id;

        public Long getId() {
            return id;
        }

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    public static class GetMemberResponse {
        private Long id;
        private String name;
        public GetMemberResponse(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
