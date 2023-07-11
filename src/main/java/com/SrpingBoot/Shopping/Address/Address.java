package com.SrpingBoot.Shopping.Address;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;


//@Embeddable

@Table(name="ADDRESS")
@Getter
@Builder
public class Address {
    @Id @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="ZIP_CODE")
    private String zip_code;

    @Column(name="CITY")
    private String city;


    @Column(name="ADDRESS")
    private String address;

    public static AddressBuilder builder(Long id,String zip_code, String city, String address){
        return new AddressBuilder()
                .id(id)
                .zip_code(zip_code)
                .city(city)
                .address(address);
    }
}
