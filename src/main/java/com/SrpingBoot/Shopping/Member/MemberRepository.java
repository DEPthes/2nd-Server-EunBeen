package com.SrpingBoot.Shopping.Member;


import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository를 상속받아 기본적인 CRUD 메서드를 상속
//save(), findById(), findAll(), deleteById() 등의 메서드 포함된 것
@org.springframework.stereotype.Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
