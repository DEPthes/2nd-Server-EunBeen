package DEPth_SpringBasic.DEPth_SpringBasic.Service;
import org.springframework.transaction.annotation.Transactional

import DEPth_SpringBasic.DEPth_SpringBasic.domain.Member;
import DEPth_SpringBasic.DEPth_SpringBasic.repository.MemberRepository;
import DEPth_SpringBasic.DEPth_SpringBasic.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//test generate 단축키(W) class drag -> ctrl+shift+T
//@Service
//@Service 내에는 @Component 존재-> Component 스캔과 자동 의존관계 설정 방법에 해당
//@Controller, @Service, @Repository 모두 @Component 존재

//java code로 직접 스프링 빈 등록하는 방법 (@Service, @Repository, @Autowired 제거 후 진행)
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    //회원가입
    public Long join(Member member){
        //중복 회원 (같은 이름) 존재X 가정
        //extract method 단축키(W) ctrl+alt+M
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
