package com.example.shopingverse.controller;

import com.example.shopingverse.dto.RequestDto.ItemRequestDto;
import com.example.shopingverse.dto.ResponseDto.CartResponseDto;
import com.example.shopingverse.model.Item;
import com.example.shopingverse.service.CartService;
import com.example.shopingverse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ItemService itemService;
    @Autowired
    CartService cartService;
    public ResponseEntity addToCart(ItemRequestDto itemRequestDto){
        try{
            Item item = itemService.createItem(itemRequestDto);
            CartResponseDto cartResponseDto = cartService.addItemToCart(itemRequestDto,item);
            return new ResponseEntity(cartResponseDto,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
