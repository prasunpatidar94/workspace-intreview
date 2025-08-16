package com.sun.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "accounts")
public class AccountContactInfoDetailsDto {

    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;


}
// it will not support the values update  ate the time of running instance because "record " in JAVA itself final in nature
//@ConfigurationProperties(prefix = "accounts")
//public record AccountContactInfoDetailsDto(String massage, Map<String, String> contactDetails,
//                                           List<String> onCallSupport) {
//
//}


//
//accounts:
//    massage: "Welcome In SunBank ...!"
//    contactDetails:
//        name: "Prasun Patidar"
//        email: "codebysun@gmail.com"
//    onCallSupport:
//            - 88888-88888
//            - 99999-99999
