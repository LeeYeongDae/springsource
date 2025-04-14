package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@RequestMapping("/member")
@Controller
public class MemberController {
     @GetMapping("/register")
     public void getRegister() {
          log.info("회원가입");
     }

     @GetMapping("/login")
     public void getLogin() {
          log.info("로그인");
     }

     @GetMapping("/logout")
     public void getLogout() {
          log.info("로그아웃");
     }

     @GetMapping("/changePwd")
     public void getChangePwd() {
          log.info("비밀번호 변경");
     }
}
