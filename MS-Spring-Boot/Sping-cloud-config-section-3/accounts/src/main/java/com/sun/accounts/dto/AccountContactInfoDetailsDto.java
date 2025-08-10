package com.sun.accounts.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
public record AccountContactInfoDetailsDto(String massage, Map<String, String> contactDetails,
                                           List<String> onCallSupport) {

}


//
//accounts:
//    massage: "Welcome In SunBank ...!"
//    contactDetails:
//        name: "Prasun Patidar"
//        email: "codebysun@gmail.com"
//    onCallSupport:
//            - 88888-88888
//            - 99999-99999
