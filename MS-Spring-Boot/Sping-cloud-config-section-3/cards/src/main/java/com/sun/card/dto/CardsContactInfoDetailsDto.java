package com.sun.card.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "cards")
public record CardsContactInfoDetailsDto(String massage, Map<String, String> contactDetails,
                                           List<String> onCallSupport) {
}