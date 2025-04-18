package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@Controller
public class HomeController {
     @GetMapping("/") // http://localhost:8080/의 기본 경로 설정
     public String getHome() {
          log.info("home 요청");
          return "home";
     }

     @GetMapping("/info")
     public String getInfo() {
          return "info";
     }

     @PostMapping("/info")
     public void postadd(int num1, int num2) {
          log.info("{} + {} = {}", num1, num2, num1 + num2);
     }

}
