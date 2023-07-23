package com.example.shopingverse.transformer;

import com.example.shopingverse.dto.RequestDto.SellerRequestDto;
import com.example.shopingverse.dto.ResponseDto.SellerResponseDto;
import com.example.shopingverse.model.Seller;

public class SellerTransformer {
    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        Seller seller=Seller.builder()
                .name(sellerRequestDto.getName())
                .emailId(sellerRequestDto.getEmailId())
                .panNo(sellerRequestDto.getPanNo())
                .build();
        return seller;
    }
    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){
        SellerResponseDto sellerResponseDto=SellerResponseDto.builder()
                .name(seller.getName())
                .emailId(seller.getEmailId())
                .build();
        return sellerResponseDto;
    }
}
