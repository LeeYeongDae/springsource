package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.team.Team;
import com.example.jpa.entity.team.TeamMember;
import com.example.jpa.repository.team.TeamMemberRepository;
import com.example.jpa.repository.team.TeamRepository;

@SpringBootTest
public class TeamRepositoryTest {

     @Autowired
     private TeamRepository teamRepository;

     @Autowired
     private TeamMemberRepository teamMemberRepository;

     @Test
     public void insertTest() {
          Team team = teamRepository.save(Team.builder().teamName("team1").build());
          teamMemberRepository.save(TeamMember.builder().userName("member1").team(team).build());
     }

     @Test
     public void insertTest2() {
          Team team = teamRepository.findById(3L).get();
          teamMemberRepository.save(TeamMember.builder().userName("member2").team(team).build());
     }
}
