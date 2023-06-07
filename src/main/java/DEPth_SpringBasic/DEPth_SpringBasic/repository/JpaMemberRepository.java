package DEPth_SpringBasic.DEPth_SpringBasic.repository;

import DEPth_SpringBasic.DEPth_SpringBasic.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
public class JpaMemberRepository implements MemberRepository {

    //각 method들에 대해 query문 작성
    private final EntityManager em;
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
    public Member save(Member member) {
        em.persist(member);
        return member;
    }
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}