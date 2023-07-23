package com.example.shopingverse.model;

import com.example.shopingverse.Enum.ProductCategory;
import com.example.shopingverse.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String productName;
    int price;
    int availableQuantity;
    @Enumerated(EnumType.STRING)
    ProductCategory category;
    @Enumerated(EnumType.STRING)
    ProductStatus productstatus;
    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();

}
