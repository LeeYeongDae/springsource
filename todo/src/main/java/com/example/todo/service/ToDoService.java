package com.example.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.todo.dto.ToDoDTO;
import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ToDoService {
     private final ToDoRepository toDoRepository;
     private final ModelMapper modelMapper;

     public ToDoDTO read(Long id) {
          ToDo todo = toDoRepository.findById(id).get();
          return modelMapper.map(todo, ToDoDTO.class);
     }

     public Long create(ToDoDTO dto) {
          ToDo todo = modelMapper.map(dto, ToDo.class);
          return toDoRepository.save(todo).getId();
     }

     public List<ToDoDTO> listCompleted(boolean completed) {
          List<ToDo> list = toDoRepository.findByCompleted(completed);

          List<ToDoDTO> todos = list.stream()
                    .map(todo -> modelMapper.map(todo, ToDoDTO.class))
                    .collect(Collectors.toList());
          return todos;
     }

     public Long changeCompleted(ToDoDTO dto) {
          ToDo todo = toDoRepository.findById(dto.getId()).get();
          todo.setCompleted(dto.isCompleted());
          return toDoRepository.save(todo).getId();
     }

     public void deleteTodo(Long id) {
          toDoRepository.deleteById(id);
     }
}
