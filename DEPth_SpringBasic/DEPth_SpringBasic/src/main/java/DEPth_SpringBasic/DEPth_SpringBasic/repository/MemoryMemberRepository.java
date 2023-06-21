package DEPth_SpringBasic.DEPth_SpringBasic.repository;

import DEPth_SpringBasic.DEPth_SpringBasic.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store=new HashMap<>();
    private static  long sequence=0L;

    @Override
    //id는 시스템에서 정해주는 객체
    //setId로 id를 부여 받고, save 메소드에서 parameter올 받은 Member 객체를
    //store에 id와 함께 put 즉, 저장하고, 저장한 member 객체를 return하는 기능.
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }


    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    //Optional.ofNullable->value가 null인 경우에도 NPE(NullPointerexception)를 발생시키지 않으며 empty 객체로 초기화

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //하나라도 있으면 값 return, 없으면 Optional에 null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    public void clearStore() {
        store.clear();
    }
    //이러한 기능들이 잘 동작하는지 확인하기 위해 test-case 작성
}
