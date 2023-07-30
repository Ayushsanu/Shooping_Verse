package com.example.shopingverse.transformer;

import com.example.shopingverse.dto.ResponseDto.ItemResponseDto;
import com.example.shopingverse.dto.ResponseDto.OrderResponseDto;
import com.example.shopingverse.model.Item;
import com.example.shopingverse.model.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderTransformer {
    public static OrderResponseDto OrderToOrderResponseDto(OrderEntity order){

        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for(Item item: order.getItems()){
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .cardUsed(order.getCardUsed())
                .orderTotal(order.getOrderTotal())
                .customerName(order.getCustomer().getName())
                .item(itemResponseDtoList)
                .build();

    }
}
