package com.sun.loans.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "loans")
public class LoansContactInfoDetailsDto {

    private String massage;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
//// it will not support the values update  ate the time of running instance because "record " in JAVA itself final in nature
//
//@ConfigurationProperties(prefix = "loans")
//public record LoansContactInfoDetailsDto(String massage, Map<String, String> contactDetails,
//                                         List<String> onCallSupport) {
//}