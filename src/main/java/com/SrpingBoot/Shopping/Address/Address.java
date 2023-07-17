package com.SrpingBoot.Shopping.Address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ADDRESS")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="ZIP_CODE")
    private String zip_code;

    @Column(name="CITY")
    private String city;


    @Column(name="ADDRESS")
    private String address;


}
