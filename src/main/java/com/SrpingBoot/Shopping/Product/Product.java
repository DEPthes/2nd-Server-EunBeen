package com.SrpingBoot.Shopping.Product;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Id @Column(name="ID")
    private Long id;

    @Column(name="CATEGORY_CODE")
    private Long category_code;

    @Column(name="NAME")
    private String name;

    @Column(name="STOCK")
    private Long stock;
}
