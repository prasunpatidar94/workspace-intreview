package com.pp.sun.static1;

public class StaticMemberCallerTry {

    Beta beta = new Beta();

    public String getBeta() {
        return Beta.staticMember();
    }
}
