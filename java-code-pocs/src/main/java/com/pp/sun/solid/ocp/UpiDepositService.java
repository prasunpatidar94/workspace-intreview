package com.pp.sun.solid.ocp;

public class UpiDepositService implements DepositPyment {
    @Override
    public void deposit() {
        System.out.println("UPI payment done..!");
    }
}
