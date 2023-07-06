package com.SrpingBoot.Shopping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Embeddable

@Table(name="ADDRESS")
@Getter @Setter
public class Address {
    @Id @Column(name="ADDRESS_ID")
    private Long id;

    @Column(name="CITY")
    private String city;

    @Column(name="ZIP_CODE")
    private String zip_code;

    @Column(name="ADDRESS")
    private String address;
}
