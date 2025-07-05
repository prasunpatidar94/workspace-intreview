package com.pp.sun.static1;

public class StaticClassCaller {
    public static void main(String[] args) {
        Baap baap = new Baap();
        Baap Beta = new Beta();
        System.out.println( baap.call());
        System.out.println( Beta.call());
        StaticMemberCallerTry staticMemberCallerTry = new StaticMemberCallerTry();
        System.out.println(staticMemberCallerTry.getBeta());
    }
}
