package com.pp.sun.java8Feature;

import java.util.Arrays;
import java.util.List;

public class LambadaExpression {
    String name1 ="Prasun";
    public static void main(String[] args) {

//        String name ="Prasun";
//        name ="Prasun";
//        List <String>names = Arrays.asList("Kamal","Rekha");
//
//        for(String nameone :names)
//            runData(nameone);

        new Metadata().showProject();

    }

    public  void runData (String name){

        Runnable runnable = ()-> System.out.println(this.name1);

        runnable.run();
    }
}

class Metadata{
    String project="SunBank";
    void showProject(){

        Runnable runnable = ()-> System.out.println(this.project);

        runnable.run();
    }
}
