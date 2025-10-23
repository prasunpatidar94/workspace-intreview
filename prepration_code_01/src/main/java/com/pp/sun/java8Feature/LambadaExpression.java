package com.pp.sun.java8Feature;

import java.util.Arrays;
import java.util.List;

public class LambadaExpression {

    public static void main(String[] args) {

        String name ="Prasun";
        name ="Prasun";
        List <String>names = Arrays.asList("Kamal","Rekha");

        for(String nameone :names)
            runData(nameone);

    }

    public static void runData (String name){

        Runnable runnable = ()-> System.out.println(name);

        runnable.run();
    }
}

class Metadata{
    String project="SunBank";
}
