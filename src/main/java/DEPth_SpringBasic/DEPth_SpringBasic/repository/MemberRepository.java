package DEPth_SpringBasic.DEPth_SpringBasic.repository;

import DEPth_SpringBasic.DEPth_SpringBasic.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //save, findById, findByName, findAll 구현
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
//구현체인  MemoryMemberRepository 생성해야 함.