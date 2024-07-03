package com.jw.menumateapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jw.menumateapp.dto.Member;
import com.jw.menumateapp.service.MemberService;

@RestController
public class MemberController {

    @Autowired
    private MemberService mService;

    @PostMapping("/api/signup")
    public ResponseEntity<String> signUp(@RequestBody Member m) {
        try {
            mService.signUp(m);
            return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
