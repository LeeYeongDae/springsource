package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@RequestMapping("/board")
@Controller
public class BoardController {
     @GetMapping("/create") // 브라우저 요청 => 컨트롤러 응답 => templetes 찾기(return 값 찾기)
     public String getCreate() {
          return "board/create";
     }

     @GetMapping("/list")
     public String getList() {
          return "board/list";
     }

     @GetMapping("/read") // 브라우저 요청 => 컨트롤러 응답 => templetes 찾기(Mapping 경로 찾기)
     public void getRead() {
          // return "board/read";
     }

     @GetMapping("/update")
     public void getUpdate() {
          // return "board/update";
     }

}
