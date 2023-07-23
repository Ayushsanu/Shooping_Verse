package com.example.shopingverse.dto.RequestDto;

import com.example.shopingverse.Enum.Gender;
import com.example.shopingverse.model.Card;
import com.example.shopingverse.model.Cart;
import com.example.shopingverse.model.OrderEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerRequestDto {
    String name;

    String emailId;

    String mobNo;


    Gender gender;

}
