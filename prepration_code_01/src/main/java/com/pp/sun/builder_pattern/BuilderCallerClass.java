package com.pp.sun.builder_pattern;

import lombok.Builder;

import java.util.Date;

public class BuilderCallerClass {
    public static void main(String[] args) {

        // it help to me immutable class data setting and perform oprations
        PaymentCreation paymentCreation = new PaymentCreation
                .builder()
                .id(123)
                .paymentAmount(123.345)
                .paymentDate(new Date())
                .paymentWay("Online")
                .build();
        System.out.println(paymentCreation.getPaymentAmount());


//
//        BuilderWithLombok builderWithLombok =
//        BuilderWithLombok
//                .builder()
//                .id(123)
//                .paymentAmount(123.345)
//                .paymentDate(new Date())
//                .paymentWay("Online")
//                .build();
//
//        System.out.println(builderWithLombok.getId());
    }
}
