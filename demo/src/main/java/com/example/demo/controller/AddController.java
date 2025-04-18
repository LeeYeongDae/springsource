package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class AddController {
     @GetMapping("/calc")
     public void getCalc() {
          log.info("calc 요청");
     }

     @PostMapping("/calc")
     public String postCalc(com.example.demo.dto.CalcDTO calcDTO) {
          log.info("calc 연산 요청 {}", calcDTO);
          int result = 0;
          switch (calcDTO.getOp()) {
               case "+":
                    result = calcDTO.getNum1() + calcDTO.getNum2();
                    break;
               case "-":
                    result = calcDTO.getNum1() - calcDTO.getNum2();
                    break;
               case "*":
                    result = calcDTO.getNum1() * calcDTO.getNum2();
                    break;
               case "/":
                    result = calcDTO.getNum1() / calcDTO.getNum2();
                    break;
          }
          calcDTO.setResult(result);
          log.info("연산 결과 {} {} {} = {}", calcDTO.getNum1(), calcDTO.getOp(), calcDTO.getNum2(),
                    calcDTO.getResult());
          return "result";
     }
}
