package com.example.shopingverse.dto.ResponseDto;

import com.example.shopingverse.Enum.ProductCategory;
import com.example.shopingverse.Enum.ProductStatus;
import com.example.shopingverse.model.Seller;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {
    String sellerName;
    String productName;
    int price;
    int availableQuantity;

    ProductCategory category;

    ProductStatus productstatus;


}
