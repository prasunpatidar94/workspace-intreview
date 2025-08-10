package com.sun.card.mapper;

import com.sun.card.dto.CardsDto;
import com.sun.card.entity.Cards;

public class CardsMapper {
    private  CardsMapper (){}
    public static Cards mapLoadDtoToLoan(CardsDto cardsDto, Cards cards) {

        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        return cards;
    }

    public static CardsDto mapLoadToLoanDto(Cards cards, CardsDto cardsDto) {

        cardsDto  = CardsDto.builder()
                .cardNumber(cards.getCardNumber())
                .amountUsed(cards.getAmountUsed())
                .availableAmount(cards.getAvailableAmount())
                .cardType(cards.getCardType())
                .totalLimit(cards.getTotalLimit())
                .mobileNumber(cards.getMobileNumber())
                .build();
        return cardsDto;
    }
}
