package com.sun.card.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "cards")
public class CardsContactInfoDetailsDto {

    private String massage;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
    // it will not support the values update  ate the time of running instance because "record " in JAVA itself final in nature
//
//    @ConfigurationProperties(prefix = "cards")
//public record CardsContactInfoDetailsDto(String massage, Map<String, String> contactDetails,
//                                           List<String> onCallSupport) {
//}