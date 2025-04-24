package com.example.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mart.entity.mart.OrderedProduct;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {

}
