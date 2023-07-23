package com.example.shopingverse.dto.RequestDto;
import com.example.shopingverse.Enum.ProductCategory;
import com.example.shopingverse.Enum.ProductStatus;
import com.example.shopingverse.model.Seller;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    String sellerEmail;

    String productName;

    int price;

    int availableQuantity;

    ProductCategory category;

    //ProductStatus productstatus;

    //Seller seller;
}
