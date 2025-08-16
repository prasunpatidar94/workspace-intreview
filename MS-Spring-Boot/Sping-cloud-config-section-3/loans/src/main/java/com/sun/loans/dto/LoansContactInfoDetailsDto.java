package com.sun.loans.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;



@ConfigurationProperties(prefix = "loans")
public record LoansContactInfoDetailsDto(String massage, Map<String, String> contactDetails,
                                         List<String> onCallSupport) {
}