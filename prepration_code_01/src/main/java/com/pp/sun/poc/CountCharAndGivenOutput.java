package com.pp.sun.poc;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountCharAndGivenOutput {

    public static void main(String[] args) {
        String in ="ababaaaabbbcccrrrdennnq";
        int count =1;
//        int i=0;
        String out ="";


//        do {
//            if ((i<in.length()-1) && in.charAt(i)== in.charAt(i+1)){
//                count++;
//            }else{
//                out=out.concat(in.charAt(i)+""+count);
//                count =1;
//            }
//            ++i;
//
//        }while (i<=in.length()-1);
//        System.out.println(out);

//

        for (int i = 0; i <= in.length()-1; i++) {
            if ( i < in.length()-1 && in.charAt(i)== in.charAt(i+1)){
                count++;
            }else{
                out=out.concat(in.charAt(i)+""+count);
                count =1;
            }

        }
        System.out.println(out);
    }


}
