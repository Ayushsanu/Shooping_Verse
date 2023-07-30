package com.example.shopingverse.transformer;

import com.example.shopingverse.dto.ResponseDto.ItemResponseDto;
import com.example.shopingverse.model.Item;

public class ItemTransformer {
    public static Item ItemRequestDtoToItem(int requiredQuantity){

        return Item.builder()
                .requiredQuantity(requiredQuantity)
                .build();
    }
    public static ItemResponseDto ItemToItemResponseDto(Item item){

        return ItemResponseDto.builder()
                .itemPrice(item.getProduct().getPrice())
                .itemName(item.getProduct().getProductName())
                .quantityAdded(item.getRequiredQuantity())
                .category(item.getProduct().getCategory())
                .build();
    }
}
