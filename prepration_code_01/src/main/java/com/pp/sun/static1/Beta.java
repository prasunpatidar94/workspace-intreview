package com.pp.sun.static1;

public class Beta  extends Baap{

    public   String name = "Prasun";
//    public static String call(){
//        return "PAPA or BETA dono ko bulaya he..!";
//    }  // can not override method hiding
    public String call(){
        return "PAPA or BETA dono ko bulaya he..!"+name;
    }
    public static String staticMember(){
        return "static Member ko bulaya he..!"+name;
    }
}
