package com.example.shopingverse.controller;

import com.example.shopingverse.Enum.ProductCategory;
import com.example.shopingverse.dto.RequestDto.ProductRequestDto;
import com.example.shopingverse.dto.ResponseDto.ProductResponseDto;
import com.example.shopingverse.exception.SellerNotFoundException;
import com.example.shopingverse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public ResponseEntity addProduct( @RequestBody ProductRequestDto productRequestDto){
        try{
            ProductResponseDto response = productService.addProduct(productRequestDto);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (SellerNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getProductByCategoriesAndPrice")
    public ResponseEntity getProductByCategoriesAndPrice(@RequestParam("price") int price, @RequestParam ("category")ProductCategory category){
        List<ProductResponseDto> productResponseDtoList=productService.getProductByCategoriesAndPrice(price,category);
        return new ResponseEntity(productResponseDtoList,HttpStatus.FOUND);

    }

}
