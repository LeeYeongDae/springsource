package com.example.todo.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.todo.entity.ToDo;

@SpringBootTest
public class ToDoRepositoryTest {
     @Autowired
     private ToDoRepository toDoRepository;

     @Test
     public void InsertTest() {
          IntStream.rangeClosed(1, 10).forEach(i -> {
               ToDo todo = ToDo.builder()
                         .content("Content" + i)
                         .build();
               toDoRepository.save(todo);
          });
     }

     @Test
     public void ReadTest() {
          toDoRepository.findAll().forEach(todo -> System.out.println(todo));
     }

     @Test
     public void DeleteTest() {
          toDoRepository.deleteById(10L);
     }

     @Test
     public void UpdateTest() {
          ToDo todo = toDoRepository.findById(1L).get();
          todo.setCompleted(true);
          toDoRepository.save(todo);
     }

     @Test
     public void ReadTest2() {
          toDoRepository.findByCompleted(true)
                    .forEach(todo -> System.out.println(todo));
     }
}
