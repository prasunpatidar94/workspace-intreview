package com.pp.sun.solid.ocp;

public class OnlineBankingDepositServices implements DepositPyment{
    @Override
    public void deposit() {
        System.out.println("Online Banking payment done ...!");
    }
}
