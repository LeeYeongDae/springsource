package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.entity.ToDo;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

     List<ToDo> findByCompleted(boolean completed);

     List<ToDo> findByImportanted(boolean importanted);

     List<ToDo> findByIdBetween(Long id, Long id2);

}
