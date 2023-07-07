package com.SrpingBoot.Shopping.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="member")
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 전략을 IDENTITY로 설정
    @Column(name="ID")
    private Long id;

    @NotEmpty
    @Column(name="NAME")
    private String name;

//    @Embedded
//    private Address address;



//    @OneToMany(mappedBy="member") //연관 관계의 주인이 아님을 표시
//    private List<Order> orders = new ArrayList<>();

}
