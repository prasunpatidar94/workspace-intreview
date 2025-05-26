package com.pp.sun.builder_pattern;

import lombok.Builder;
import lombok.ToString;

import java.util.Date;

@ToString
@Builder
public class BuilderWithLombok {

    private Integer id;
    private String paymentWay;
    private Date paymentDate;
    private Double paymentAmount;
}
