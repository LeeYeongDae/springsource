package com.example.relation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.relation.entity.team.Team;
import com.example.relation.entity.team.TeamMember;
import com.example.relation.repository.team.TeamMemberRepository;
import com.example.relation.repository.team.TeamRepository;

import jakarta.transaction.Transactional;

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
          Team team = teamRepository.findById(1L).get();
          teamMemberRepository.save(TeamMember.builder().userName("member2").team(team).build());
     }

     @Test
     public void readTest1() {
          Team team = teamRepository.findById(1L).get();
          TeamMember teamMember = teamMemberRepository.findById(1L).get();

          System.out.println(team);
          System.out.println(teamMember);
     }

     @Test
     public void readTest2() {
          TeamMember teamMember = teamMemberRepository.findById(1L).get();

          System.out.println(teamMember);
          // 객체그래프 탐색
          System.out.println(teamMember.getTeam());
     }

     @Test
     public void updateTest() {
          TeamMember teamMember = teamMemberRepository.findById(1L).get();
          teamMember.setTeam(teamRepository.findById(2L).get());
          teamMemberRepository.save(teamMember);
     }

     @Test
     public void deleteTest() {

          TeamMember teamMember = teamMemberRepository.findById(2L).get();
          teamMember.setTeam(null);
          teamMemberRepository.save(teamMember);
          teamRepository.deleteById(2L);
     }

     @Transactional
     @Test
     public void readBiTest1() {
          Team team = teamRepository.findById(1L).get();
          System.out.println(team);

          team.getMembers().forEach(member -> System.out.println(member));
     }

     @Test
     public void insertTest3() {
          Team team = Team.builder().teamName("team3").build();
          TeamMember member = TeamMember.builder().userName("user").team(team).build();
          team.getMembers().add(member);

          teamRepository.save(team);
     }

     @Test
     public void deleteTest2() {

          teamRepository.deleteById(4L);
     }
}
