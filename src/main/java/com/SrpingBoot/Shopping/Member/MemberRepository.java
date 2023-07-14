package com.SrpingBoot.Shopping.Member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository를 상속받아 기본적인 CRUD 메서드를 상속
//save(), findById(), findAll(), deleteById() 등의 메서드가 포함되어 있다.
@Repository
public interface MemberRepository extends JpaRepository<MemberDto, Long> {

}
