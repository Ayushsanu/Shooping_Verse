package com.example.shopingverse.model;

import com.example.shopingverse.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "card")
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true)
    String cardNo;
    int cvv;

    Date validTill;
    @Enumerated(EnumType.STRING)
    CardType cardType;
    @ManyToOne
    @JoinColumn
    Customer customer;
}
