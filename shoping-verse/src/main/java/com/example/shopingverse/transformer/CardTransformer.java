package com.example.shopingverse.transformer;

import com.example.shopingverse.dto.RequestDto.CardRequestDto;
import com.example.shopingverse.dto.ResponseDto.CardResponseDto;
import com.example.shopingverse.model.Card;

public class CardTransformer {
    public static Card CardRequestDtoToCard(CardRequestDto cardRequestDto){

        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardType(cardRequestDto.getCardType())
                .validTill(cardRequestDto.getValidTill())
                .cvv(cardRequestDto.getCvv())
                .build();
    }

    public static CardResponseDto CardToCardResponseDto(Card card){

        return CardResponseDto.builder()
                .customerName(card.getCustomer().getName())
                .validTill(card.getValidTill())
                .cardType(card.getCardType())
                .build();
    }
}
