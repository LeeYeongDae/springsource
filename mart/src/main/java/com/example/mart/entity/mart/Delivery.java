package com.example.mart.entity.mart;

import com.example.mart.entity.mart.constant.DeliveryStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // (exclude = "member")
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Delivery {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "DELIVERY_ID")
     private Long id;

     private String post;

     private String address;

     private String specificAddress;

     @Enumerated(EnumType.STRING)
     private DeliveryStatus status;

     @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
     private Order order;
}
