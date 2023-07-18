package com.SrpingBoot.Shopping.Member;

import com.SrpingBoot.Shopping.Order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Table(name="MEMBER")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Min(0)
    @Column(name="POINT")
    private int point;

    public void updateMember(String newName, String newEmail, String newPassword) {
        this.name = newName;
        this.email = newEmail;
        this.password = newPassword;
    }


    @OneToMany(mappedBy="member_id") //연관 관계의 주인이 아님을 표시
    private List<Order> orders = new ArrayList<>();


}
