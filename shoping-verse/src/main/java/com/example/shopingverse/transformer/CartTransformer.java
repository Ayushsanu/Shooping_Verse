package com.example.shopingverse.transformer;



import com.example.shopingverse.dto.ResponseDto.CartResponseDto;
import com.example.shopingverse.dto.ResponseDto.ItemResponseDto;
import com.example.shopingverse.model.Cart;
import com.example.shopingverse.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {

    public static CartResponseDto CartToCartReponseDto(Cart cart){

        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for(Item item: cart.getItems()){
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtoList)
                .build();
    }
}
