package com.sun.card.service;

import com.sun.card.dto.CardsDto;
import org.springframework.stereotype.Service;

@Service
public interface ICardsService {

    void createCard(CardsDto cardsDto);

    CardsDto fetchByMobileOrCardNumber(String findByValue, String findBy);

    boolean updateCard(CardsDto cardsDto);

    boolean deleteByMobileOrCardNumber(String findByValue, String findBy);
}
