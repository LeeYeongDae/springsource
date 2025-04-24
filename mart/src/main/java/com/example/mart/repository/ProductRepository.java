package com.example.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mart.entity.mart.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}