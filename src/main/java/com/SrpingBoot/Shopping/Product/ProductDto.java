package com.SrpingBoot.Shopping.Product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductDto {
    private Long id;
    private Long categoryCode;
    private String name;
    private String desc;
    private Long price;
    private Long stock;

    @Data
    static class CreateProductRequest{
        @NotNull
        private Long categoryCode;
        @NotEmpty
        private String name;

        private String desc;
        @NotNull
        private Long price;
        @NotNull
        private Long stock;

    }
    @Data
    static class CreateProductResponse{
        private Long id;
        public CreateProductResponse(Long id) {
            this.id = id;
        }

    }




}
