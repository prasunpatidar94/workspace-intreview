package com.sun.card.service.impl;

import com.sun.card.dto.CardsDto;
import com.sun.card.entity.Cards;
import com.sun.card.exception.InvalidArgumentPassedException;
import com.sun.card.exception.ResourceAlreadyExistsException;
import com.sun.card.exception.ResourceNotFoundException;
import com.sun.card.mapper.CardsMapper;
import com.sun.card.repository.CardsRepository;
import com.sun.card.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class CardsServiceImpl implements ICardsService {
    private CardsRepository cardsRepository;


    @Override
    public void createCard(CardsDto cardsDto) {

        if (cardsRepository.findByMobileNumber(cardsDto.getMobileNumber()).isPresent()) {
            throw new ResourceAlreadyExistsException("Cards already registered with given mobileNumber " + cardsDto.getMobileNumber());
        }
        cardsRepository.save(createNewCard(cardsDto));
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Optional<Cards> loanOptional = cardsRepository.findByCardNumber(cardsDto.getCardNumber());
        Cards cards = loanOptional.orElseThrow(() -> new ResourceNotFoundException("Cards", "cardNumber", cardsDto.getCardNumber()));
        cardsDto.setAvailableAmount(cardsDto.getTotalLimit()-cardsDto.getAmountUsed());
        cardsRepository.save(CardsMapper.mapLoadDtoToLoan(cardsDto, cards));
        return true;
    }

    @Override
    public CardsDto fetchByMobileOrCardNumber(String findByValue, String findBy) {

        CardsDto cardsDto = null;
        if (findBy.equalsIgnoreCase("MOB")) {
            cardsDto = CardsMapper.mapLoadToLoanDto(
                    cardsRepository.findByMobileNumber(findByValue).orElseThrow(() -> new ResourceNotFoundException("Cards", "mobileNumber", findByValue)), cardsDto
            );
        } else if (findBy.equalsIgnoreCase("CN")) {
            cardsDto = CardsMapper.mapLoadToLoanDto(
                    cardsRepository.findByCardNumber(findByValue).orElseThrow(() -> new ResourceNotFoundException("Cards", "cardNumber", findByValue))
                    , cardsDto);
        } else {
            throw new InvalidArgumentPassedException("Cards", "mobileNumber/cardNumber", findByValue);
        }

        return cardsDto;
    }

    @Override
    public boolean deleteByMobileOrCardNumber(String findByValue, String findBy) {
        boolean isDeleted = false;
        if (findBy.equalsIgnoreCase("MOB")) {

            cardsRepository.deleteByCardId(cardsRepository.findByMobileNumber(findByValue).orElseThrow(() -> new ResourceNotFoundException("Cards", "mobileNumber", findByValue)).getCardId());
            isDeleted = true;

        } else if (findBy.equalsIgnoreCase("CN")) {
            cardsRepository.findByCardNumber(findByValue).orElseThrow(() -> new ResourceNotFoundException("Cards", "cardNumber", findByValue));
            cardsRepository.deleteByCardId(cardsRepository.findByCardNumber(findByValue).orElseThrow(() -> new ResourceNotFoundException("Cards", "cardNumber", findByValue)).getCardId());
            isDeleted = true;
        } else {
            throw new InvalidArgumentPassedException("Cards", "mobileNumber/cardNumber", findByValue);
        }
        return isDeleted;
    }

    private Cards createNewCard(CardsDto cardsDto) {
        return CardsMapper.mapLoadDtoToLoan(
                CardsDto.builder()
                .amountUsed(0)
                .availableAmount(cardsDto.getTotalLimit())
                .cardNumber(createCardNumber())
                .cardType(cardsDto.getCardType())
                .mobileNumber(cardsDto.getMobileNumber())
                .totalLimit(cardsDto.getTotalLimit())
                .build(),
                new Cards());

    }

    private String createCardNumber() {
        return Long.toString(1000000000000000000L + new Random().nextLong(900000000000000000L));
    }


}
