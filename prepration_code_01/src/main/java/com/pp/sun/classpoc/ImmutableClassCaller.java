package com.pp.sun.classpoc;

import java.util.Arrays;
import java.util.Calendar;

public class ImmutableClassCaller {

    public static void main(String[] args) {
        ImmutableProductClass immutableProductClassOne
                = new ImmutableProductClass(1000L,"Iphone",
                127453.756,10,"Free Size", Calendar.getInstance().getTime(),
                Arrays.asList("Indore","Bhopal","Bengaluru","Kasrawad"));

        ImmutableProductClass immutableProductClassTwo
                = new ImmutableProductClass(1001L,"Moto G",
                12790.756,5,"Free Size", Calendar.getInstance().getTime(),
                Arrays.asList("Bhopal","Bengaluru"));

        // this value not set due to defencive copy of the object in immutable class to make filed immutable
        immutableProductClassOne.getProductAvabilityLocations().set(1,"Kelash");
        immutableProductClassTwo.getProductExpireDate().setTime(8466489984894L);

        System.out.println("One : "+immutableProductClassOne);
        System.out.println("Two : "+immutableProductClassTwo);
    }

}

