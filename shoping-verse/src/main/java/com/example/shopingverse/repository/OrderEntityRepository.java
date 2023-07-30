package com.example.shopingverse.repository;

import com.example.shopingverse.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity,Integer> {
}
