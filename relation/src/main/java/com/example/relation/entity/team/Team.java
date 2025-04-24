package com.example.relation.entity.team;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.ToString;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

// One To Many (한 팀에는 여러 멤버)
@ToString(exclude = "members")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Team {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "team_id")
     private Long id;

     private String teamName;

     @Builder.Default
     @OneToMany(mappedBy = "team", fetch = FetchType.EAGER) // Catch 타입 변경, 관계 테이블 정보 즉시 가지고 나오기
     private List<TeamMember> members = new ArrayList<>();
}
