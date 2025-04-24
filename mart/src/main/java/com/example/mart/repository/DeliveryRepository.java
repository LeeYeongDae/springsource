package com.example.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mart.entity.mart.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}