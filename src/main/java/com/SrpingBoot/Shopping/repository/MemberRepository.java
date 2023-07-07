package com.SrpingBoot.Shopping.repository;


import com.SrpingBoot.Shopping.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository를 상속받아 기본적인 CRUD 메서드를 상속
//save(), findById(), findAll(), deleteById() 등의 메서드 포함된 것
@Repository

public interface MemberRepository extends JpaRepository<Member, Long> {

}
