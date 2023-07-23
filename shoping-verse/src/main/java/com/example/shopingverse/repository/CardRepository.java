package com.example.shopingverse.repository;

import com.example.shopingverse.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
    public Card findByCardNo(String cardNo);
}
