package com.example.shopingverse.transformer;

import com.example.shopingverse.Enum.ProductStatus;
import com.example.shopingverse.dto.RequestDto.ProductRequestDto;
import com.example.shopingverse.dto.ResponseDto.ProductResponseDto;
import com.example.shopingverse.model.Product;

public class ProductTransformer {
    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){
        Product product=Product.builder()

                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .availableQuantity(productRequestDto.getAvailableQuantity())
                .category(productRequestDto.getCategory())
                .productstatus(ProductStatus.AVAILABLE)
                .build();
        return product;
    }
    public static ProductResponseDto productToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .availableQuantity(product.getAvailableQuantity())
                .category(product.getCategory())
                .productstatus(product.getProductstatus())
                .sellerName(product.getSeller().getName())
                .build();
    }
}
