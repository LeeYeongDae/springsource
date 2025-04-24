package com.example.relation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.relation.entity.cascade.Child;
import com.example.relation.entity.cascade.Parent;
import com.example.relation.repository.cascade.ChildRepository;
import com.example.relation.repository.cascade.ParentRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ParentRepositoryTest {
     @Autowired
     private ParentRepository parentRepository;
     @Autowired
     private ChildRepository childRepository;

     @Test
     public void testInsert() {
          Parent parent = new Parent();
          parent.setName("parent1");
          parentRepository.save(parent);

          Child child = new Child();
          child.setName("child1");
          child.setParent(parent);
          childRepository.save(child);

          child = new Child();
          child.setName("child2");
          child.setParent(parent);
          childRepository.save(child);
     }

     @Test
     public void testInsert2() {
          Parent parent = new Parent();
          parent.setName("parent2");

          parent.getChilds().add(Child.builder().name("child1").parent(parent).build());
          parent.getChilds().add(Child.builder().name("child2").parent(parent).build());
          parent.getChilds().add(Child.builder().name("child3").parent(parent).build());

          parentRepository.save(parent);
     }

     @Test
     public void testDelete1() {
          parentRepository.deleteById(2L);
     }

     @Commit
     @Transactional
     @Test
     public void testDelete2() {
          Parent parent = parentRepository.findById(4L).get();
          parent.getChilds().remove(0);
          parentRepository.save(parent);
     }
}
