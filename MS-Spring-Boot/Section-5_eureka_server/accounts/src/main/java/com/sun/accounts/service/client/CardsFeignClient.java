package com.sun.accounts.service.client;

import com.sun.accounts.dto.client.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cards")
public interface CardsFeignClient {

    @GetMapping(value = "/cards/api/fetch" , consumes = "application/json")
    ResponseEntity<CardsDto> fetchByMobileOrCardNumber(@RequestParam String findByValue, @RequestParam String findBy) ;

    }
