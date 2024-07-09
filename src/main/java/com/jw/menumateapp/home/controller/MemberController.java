package com.jw.menumateapp.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jw.menumateapp.home.dto.SignupMemberDTO;
import com.jw.menumateapp.home.service.MemberService;

@RestController
@RequestMapping("/api") // API 경로 통일
public class MemberController {

    @Autowired
    private MemberService mService;

    @PostMapping("/signupProc")
    public ResponseEntity<String> signUp(@RequestBody SignupMemberDTO signupMemberDTO) {
        try {
            System.out.println("회원가입 요청 수신됨: " + signupMemberDTO.getUserId());
            mService.signUp(signupMemberDTO);
            System.out.println("회원가입 서비스 호출됨");
            return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("회원가입 중 오류 발생: " + e.getMessage());
            return new ResponseEntity<>("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
