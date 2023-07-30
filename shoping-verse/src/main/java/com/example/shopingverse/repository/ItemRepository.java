package com.example.shopingverse.repository;

import com.example.shopingverse.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
