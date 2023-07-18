package com.SrpingBoot.Shopping.Product;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRODUCT")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @NotNull
    @Column(name="CATEGORY_CODE")
    private Long categoryCode;

    @NotEmpty
    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String desc;

    @NotNull
    @Column(name="PRICE")
    private Long price;

    @NotNull
    @Column(name="STOCK")
    private Long stock;



    public void updateProduct(Long newCategoryCode,
                              String newName,
                              String newDesc,
                              Long newPrice
    ) {
        this.categoryCode = newCategoryCode;
        this.name = newName;
        this.desc = newDesc;
        this.price = newPrice;
    }
}
