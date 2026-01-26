package com.pp.sun.solid.ocp;

public class OfflineDepositService  implements DepositPyment{
    @Override
    public void deposit() {
        System.out.println("Case payment done...!");
    }
}
