package com.example.jpa.entity.team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

// One To Many (한 팀에는 여러 멤버)
@ToString
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
}
