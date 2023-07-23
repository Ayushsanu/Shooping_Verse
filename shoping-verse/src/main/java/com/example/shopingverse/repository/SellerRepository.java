package com.example.shopingverse.repository;

import com.example.shopingverse.model.Customer;
import com.example.shopingverse.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository <Seller,Integer> {
    public Seller findByEmailId(String email);
}
