package com.example.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book.dto.BookDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/book")
public class BookController {

     @GetMapping("/list")
     public void getList() {
          log.info("book list");
     }

     @GetMapping("/read /modify")
     public void getRead() {
          log.info("book read");
     }

     @PostMapping("/modify")
     public void postModify(BookDTO dto) {
          log.info("book modify");
     }

     @GetMapping("/create")
     public void getCreate() {
          log.info("book create");
     }

     @PostMapping("/remove")
     public void PostRemove() {
          log.info("book remove");
     }

}
