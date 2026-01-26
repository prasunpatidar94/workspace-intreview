package com.pp.sun.solid.ocp;

// Wrong approach for class code modification as per Open/closed solid principe
public class DepositPaymentWithBadApproach{

    // existing method
    public void depositAmountOffline(){
        System.out.println("Amount Deposit by bankers successfully..! ");
    }

    // new method
    public void DepositPaymentOnline(){
        System.out.println("Amount Deposit by online banking/UPI successfully..! ");
    }
}
