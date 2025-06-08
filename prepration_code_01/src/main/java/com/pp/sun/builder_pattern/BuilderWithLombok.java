package com.pp.sun.builder_pattern;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Builder
@Getter
public class BuilderWithLombok {

    private Integer id;
    private String paymentWay;
    private Date paymentDate;
    private Double paymentAmount;
}
