package com.pp.sun.solid.ocp;

public class ServicesCallerClass {
    public static void main(String[] args) {
        DepositPyment offlineDepositService= new OfflineDepositService();
        DepositPyment upiDepositService= new UpiDepositService();
        DepositPyment onlineBankingDepositServices= new OnlineBankingDepositServices();

       offlineDepositService.deposit();
       onlineBankingDepositServices.deposit();
       upiDepositService.deposit();
    }
}
