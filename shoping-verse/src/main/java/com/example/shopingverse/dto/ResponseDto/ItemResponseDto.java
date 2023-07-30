package com.example.shopingverse.dto.ResponseDto;

import com.example.shopingverse.Enum.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemResponseDto {

    String itemName;
    int itemPrice;
    int quantityAdded;
    ProductCategory category;
}
