package com.example.mart.entity.mart;

import com.example.mart.entity.BaseEntity;

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
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = { "item", "category" })
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class CategoryItem extends BaseEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @JoinColumn(name = "ITEM_ID")
     @ManyToOne(fetch = FetchType.LAZY)
     private Product item;

     @JoinColumn(name = "CATEGORY_ID")
     @ManyToOne(fetch = FetchType.LAZY)
     private Category category;

}
