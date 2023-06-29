package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //트랜잭션 단위로 처리
        EntityTransaction tx=em.getTransaction();
        //transaction 시작
        tx.begin();


        try{

            //회원 등록
            //Member 객체 생성
//            Member member=new Member();
//
//            member.setId(1L);
//            member.setName("강영현");
//
//            em.persist(member); //member 저장

            //All data show
            //JPQL을 사용해 List로 결과를 받아 출력
//            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }


            //회원 이름 조회
//            Member findMember = em.find(Member.class, 1L);
//
//            System.out.println(findMember.getName());


            //회원 수정 (resist 불필요)
            //id=2L인 "김민식" -> "최정"으로 update
//            Member updateMember = em.find(Member.class, 2L);
//
//            updateMember.setName("최정");
//
//            //수정 내용 확인
//            System.out.println("수정된 회원 이름");
//            System.out.println(updateMember.getName());


            //회원 삭제
            //id=2L인 회원 정보 삭제
            Member removeMember=em.find(Member.class, 2L);
            em.remove(removeMember);


            //하나의 transaction이 끝남->commit
            tx.commit();

        } catch (Exception e){
            //예외 발생 시 rollback
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
