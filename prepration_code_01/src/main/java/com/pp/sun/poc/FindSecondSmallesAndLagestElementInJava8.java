package com.pp.sun.poc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class FindSecondSmallesAndLagestElementInJava8 {
    public static void main(String[] args) {

        int in[]={10,20,56,34,23,47,50,3,1,70,100};

     Integer out =Arrays.stream(in).sorted().skip(1).findFirst().getAsInt();
        System.out.println(out);
//        Integer out1 =Arrays.stream(in).sorted(Comparator.comparingInt(e->e)).skip(1).findFirst().getAsInt();
        System.out.println(out);

    }
}
