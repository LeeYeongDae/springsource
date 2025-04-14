package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class HomeController {
     @GetMapping("/") // http://localhost:8080/의 기본 경로 설정
     public String getHome() {
          log.info("home 요청");
          return "home";
     }

     @GetMapping("/basic")
     public String getInfo() {
          return "info";
     }
}
