package DEPth_SpringBasic.DEPth_SpringBasic.repository;
import DEPth_SpringBasic.DEPth_SpringBasic.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository =new MemoryMemberRepository();

    //여러번 테스트 실행-> 테스트 DB에 직전 테스트 결과가 남을 수 있음.
    // 따라서 @Aftereach를 사용해 각 테스트가 종료할 때마다 이를 실행하도록 한다.
    // 해당 test에서는 @Aftereach를 사용해 메모리 DB에 저장된 데이터를 clear하도록 한다.

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    //실행 가능
    public void save(){
        Member member=new Member();
        member.setName("spring");
        repository.save(member);
        Member result=repository.findById(member.getId()).get();
        //1. 출력결과로 확인
        //System.out.println("result = "+(result==member));
        //2.
        //Assertions.assertEquals(member,result);

        //org.junit.jupiter.api.Assertions
        //public static void assertEquals(     Object expected,
        //        Object actual ) expected->기대되는 값 즉, member 순서 주의!
        //3.org.assertj.core.api
        //static import 설정하면 Assertions 생략 가능
        assertThat(member).isEqualTo(result);
        //org.assertj.core.api.Assertions

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //ctrl c+v 후 shift+F6 단축키로 한번에 rename 가능
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

}
