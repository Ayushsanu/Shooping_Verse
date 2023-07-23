package com.example.shopingverse.service;

import com.example.shopingverse.dto.RequestDto.SellerRequestDto;
import com.example.shopingverse.dto.ResponseDto.SellerResponseDto;
import com.example.shopingverse.model.Seller;
import com.example.shopingverse.repository.SellerRepository;
import com.example.shopingverse.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public  SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {
        // dto->entity
        Seller seller= SellerTransformer.sellerRequestDtoToSeller(sellerRequestDto);
        //save the entity
        Seller savedSeller=sellerRepository.save(seller);
        // entity to reponsedtO
        SellerResponseDto sellerResponseDto=SellerTransformer.sellerToSellerResponseDto(savedSeller);
        return sellerResponseDto;

    }
}
