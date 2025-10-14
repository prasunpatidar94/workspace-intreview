package com.pp.sun.poc;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseSentenceWithoutExtraSpace {
    public static void main(String[] args) {
        String in ="Reverse words in a sentence without using extra space";

        List<String> inList =  new ArrayList<>();
        List<String> inListOut =  new ArrayList<>();
        inList = Arrays.asList(in.split(" "));

        System.out.println(inList);
        Collections.reverse(inList);

//        inListOut.add(2,"pp");

        System.out.println(inList.stream().collect(Collectors.joining(" ")));
//
//        for (int i = 0; i <= (inList.size()-1)/2; i++) {
//            inList.add(i,inList.get(inList.size()-i));
//            inList.add((inList.size()-i),inList.get(i));
//
//        }
    }
}
