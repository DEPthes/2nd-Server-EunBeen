package DEPth_SpringBasic.DEPth_SpringBasic;

import DEPth_SpringBasic.DEPth_SpringBasic.Service.MemberService;
import DEPth_SpringBasic.DEPth_SpringBasic.repository.MemberRepository;
import DEPth_SpringBasic.DEPth_SpringBasic.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    } //memberService 스프링 빈에 등록

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
