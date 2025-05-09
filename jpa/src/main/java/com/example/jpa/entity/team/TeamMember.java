package com.example.jpa.entity.team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Many To One (한 멤버는 한 팀에만 소속)
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class TeamMember {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "member_id")
     private Long id;

     private String userName;

     @ManyToOne
     private Team team;
}
