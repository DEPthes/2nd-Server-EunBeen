package com.SrpingBoot.Shopping.service;

import com.SrpingBoot.Shopping.domain.Member;
import com.SrpingBoot.Shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long join(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }


//    MemberRepositoryository의 save 메서드 호출 이후에 member 객체의 ID가 자동으로 할당됩니다.
//    member.setId(null)을 호출하여 ID를 null로 초기화하면, Hibernate가 자동으로 ID를 생성하여 할당합니다.
//    이후에 member.getId()를 호출하면 올바른 ID 값을 얻을 수 있습니다.
}
