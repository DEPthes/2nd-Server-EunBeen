package DEPth_SpringBasic.DEPth_SpringBasic;

import DEPth_SpringBasic.DEPth_SpringBasic.Service.MemberService;
import DEPth_SpringBasic.DEPth_SpringBasic.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration

public class SpringConfig {
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
//스프링 데이터 JPA가 SpringDataJpaMemberRepository 를 스프링 빈으로 자동 등록