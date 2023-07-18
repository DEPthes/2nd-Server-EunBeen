package com.SrpingBoot.Shopping.Member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long join(MemberDto.CreateMemberRequest request) {
        Member member = Member.builder()
                .name(request.getName())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();

        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAll() { return memberRepository.findAll(); }


    public void deleteById(Long id) { memberRepository.deleteById(id); }


    public void update(Member member) { memberRepository.save(member); }
}
