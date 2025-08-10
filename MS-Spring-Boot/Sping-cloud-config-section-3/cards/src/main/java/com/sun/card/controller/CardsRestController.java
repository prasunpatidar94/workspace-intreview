package com.sun.card.controller;

import com.sun.card.constant.CardsConstants;
import com.sun.card.dto.CardsDto;
import com.sun.card.dto.ErrorResponseDto;
import com.sun.card.dto.ResponseDto;
import com.sun.card.service.ICardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cards/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Tag(name = "Cards Microservice - (SunBank)", description = "Rest api for Cards microservice with all CURD operations ")
@Validated
public class CardsRestController {

@Autowired
    private ICardsService iCardsService;

    @Operation(summary = "Cards Service Health Checker", description = "Rest Service to support to check  health for Cards Microservices")
    @ApiResponse(responseCode = "200", description = "Healthy")
    @GetMapping("/cards")
    public String health() {
        return "Healthy";
    }

    @Operation(summary = "Create Account Rest API", description = "Rest API to create account and customer in SunBank")
    @ApiResponse(responseCode = CardsConstants.STATUS_201, description = CardsConstants.MESSAGE_201)
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody CardsDto cardsDto ) {

        iCardsService.createCard(cardsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDto.builder().StatusCode(CardsConstants.STATUS_201).StatusSms(CardsConstants.MESSAGE_201).build());
    }

    @Operation(summary = "Update Account Rest API", description = "Rest API to Update account details inside SunBank")
    @ApiResponses({@ApiResponse(responseCode = CardsConstants.STATUS_200, description = CardsConstants.MESSAGE_200), @ApiResponse(responseCode = CardsConstants.STATUS_417, description = CardsConstants.MESSAGE_417_UPDATE), @ApiResponse(responseCode = CardsConstants.STATUS_500, description = CardsConstants.MESSAGE_500)})

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody CardsDto cardsDto) {

        return (iCardsService.updateCard(cardsDto)) ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200)) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE));
    }

    @Operation(summary = "Fetch Account Rest API", description = "Rest API to fetch account details using mobile number from SunBank")
    @ApiResponse(responseCode = CardsConstants.STATUS_200, description = CardsConstants.MESSAGE_200)
    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchByMobileOrCardNumber(@NotEmpty(message = "findByValue should not be Empty") @RequestParam String findByValue, @NotEmpty(message = "findBy should not be Empty") @RequestParam String findBy) {
        return ResponseEntity.status(HttpStatus.OK).body(iCardsService.fetchByMobileOrCardNumber(findByValue, findBy));
    }

    @Operation(summary = "Delete Account Rest API", description = "Rest API to Delete account details inside SunBank")
    @ApiResponses({@ApiResponse(responseCode = CardsConstants.STATUS_200, description = CardsConstants.MESSAGE_200), @ApiResponse(responseCode = CardsConstants.STATUS_417, description = CardsConstants.MESSAGE_417_DELETE), @ApiResponse(responseCode = CardsConstants.STATUS_500, description = CardsConstants.MESSAGE_500, content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteByMobileOrCardNumber(@NotEmpty(message = "findByValue should not be Empty") @RequestParam String findByValue, @NotEmpty(message = "findBy should not be Empty") @RequestParam String findBy) {
        return (iCardsService.deleteByMobileOrCardNumber(findByValue, findBy)) ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200)) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_DELETE));
    }

}
