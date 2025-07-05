package com.pp.sun.program;

import java.util.HashMap;
import java.util.Map;

public class GiveCountStringCharOnlyRepeted {

    public static void main(String[] args) {
        String input = "PPHHHUGJJJJYRTEKPPPPPPPKKLLLHYEWWWQQQQNNNHHGGFFDDPYKM";
        int count=1;
        for (int i = 1; i < input.length(); i++) {

                if ( input.charAt(i) == input.charAt(i - 1)) {
                    count++;
                } else if(count>1)  {
                    System.out.println(input.charAt(i-1) +":"+ count);
                    count=1;
                }


        }
    }
}
