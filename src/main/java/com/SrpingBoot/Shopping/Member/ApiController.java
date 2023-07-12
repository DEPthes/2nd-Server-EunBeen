package com.SrpingBoot.Shopping.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@Controller , @ResponseBody를 포함한 @RestController
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final MemberService memberService;

//    @PostMapping("/api/members")
//    public ResponseEntity<MemberDto.MemberResponse> saveMember(@RequestBody @Valid MemberDto.CreateMemberRequest request) {
//        Member member = Member.builder()
//                .name(request.getName())
//                .password(request.getPassword())
//                .email(request.getEmail())
//                .point(request.getPoint())
//                .build();
//
//        Long id = service.join(member);
//
//        MemberDto.MemberResponse response = MemberDto.MemberResponse.builder()
//                .id(id)
//                .name(member.getName())
//                .email(member.getEmail())
//                .point(member.getPoint())
//                .build();
//
//        return ResponseEntity.ok(response);
//    }

    @PostMapping("/api/members")
    public void saveMember(@RequestBody @Valid MemberDto.CreateMemberRequest request) {
        Member member = Member.builder()
                .name(request.getName())
                .password(request.getPassword())
                .email(request.getEmail())
                .point(request.getPoint())
                .build();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        //transaction 시작
        tx.begin();
        try {

            //이름, 비밀번호 persist()
            member.setName(request.getName());
            member.setName(request.getPassword());

            em.persist(member);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

//    @GetMapping("/api/members/{id}")
//    public ResponseEntity<Dto.GetMemberResponse> getMember(@PathVariable Long id) {
//        Member member = service.getMemberById(id);
//        if (member == null) {
//            return ResponseEntity.notFound().build();
//        }
//        Dto.GetMemberResponse response = new Dto.GetMemberResponse(member.getId(), member.getName());
//        return ResponseEntity.ok(response);
//    }






//

