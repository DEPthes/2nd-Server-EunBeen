package com.SrpingBoot.Shopping.Member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;


@Entity
@Table(name="member")
@Getter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 전략을 IDENTITY로 설정
    @Column(name="ID")
    private Long id;

    @NotEmpty
    @Column(name="NAME")
    private String name;

    @NotEmpty
    @Column(name="PASSWORD")
    private String password;

    @NotEmpty
    @Column(name="EMAIL")
    private String email;

    @NotEmpty
    @Column(name="POINT")
    private int point;





//    @OneToMany(mappedBy="member") //연관 관계의 주인이 아님을 표시
//    private List<Order> orders = new ArrayList<>();

}
