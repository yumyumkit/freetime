//package com.project.yumyum.service;
//
//import com.project.yumyum.dto.MemberFormDto;
//import com.project.yumyum.entity.Member;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.transaction.Transactional;
//
//import static org.junit.Assert.*;
//
//@SpringBootTest
//@Transactional
//class MemberServiceTest {
//
//    @Autowired
//    MemberService memberService;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    //Controller에서 POST 입력값을 기반으로 memberFormDto 객체 생성할 예정
//    public Member createMember() {
//        MemberFormDto memberFormDto = new MemberFormDto();
//        memberFormDto.setEmail("test@gmail.com");
//        memberFormDto.setName("홍길동");
//        memberFormDto.setPassword("1234");
//        return Member.createMember(memberFormDto, passwordEncoder);
//    }
//
//    @Test
//    @DisplayName("회원가입 테스트")
//    public void saveMemberTest() {
//        Member member = createMember();
//        Member savedMember = memberService.saveMember(member);
//
//        assertEquals(member.getEmail(), savedMember.getEmail());
//        assertEquals(member.getName(), savedMember.getName());
//        assertEquals(member.getPassword(), savedMember.getPassword());
//        assertEquals(member.getRole(), savedMember.getRole());
//
//    }
//
//    @Test
//    @DisplayName("중복 회원가입 테스트")
//    void validateDuplicateMember() {
//        //given
//        Member member1 = createMember();
//        Member member2 = createMember();
//        memberService.saveMember(member1);
//
//        //when
//        Throwable e = assertThrows(IllegalStateException.class, () ->{
//            memberService.saveMember(member2);
//        });
//
//        //then
//        assertEquals("이미 가입된 회원입니다.", e.getMessage());
//
//    }
//}