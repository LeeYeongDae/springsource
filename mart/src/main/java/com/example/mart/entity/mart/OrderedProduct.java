package com.example.mart.entity.mart;

import com.example.mart.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString(exclude = { "product", "order" })
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class OrderedProduct extends BaseEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ORDER_PRODUCT_ID")
     private Long id;

     @JoinColumn(name = "PRODUCT_ID")
     @ManyToOne(fetch = FetchType.LAZY)
     private Product product;

     @JoinColumn(name = "ORDER_ID")
     @ManyToOne(fetch = FetchType.LAZY)
     private Order order;

     private int orderPrice;

     private int count;
}
