package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();

        //트랜잭션 단위로 처리
        EntityTransaction tx=em.getTransaction();
        //transaction 시작
        tx.begin();


        try{
            //회원 등록
//            Member member=new Member();
//
//            member.setId(2L);
//            member.setName("HelloB");
//
//            //persist로 memeber 저장
//            em.persist(member);
//
//            //회원 조회
//            Member findMember = em.find(Member.class,1L);
//
//            //회원 수정
//            findMember.setName("HelloJPA");
//            //resist 불필요
//
//            //회원 삭제
//            em.remove(findMember);

            //JPQL
            List<Member> result=em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList(); ////5번부터 8개 get


            //하나의 transaction이 끝남->commit
            tx.commit();

            //JPQL

        } catch (Exception e){
            //예외 발생 시 rollback
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
