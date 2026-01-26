package com.pp.sun.solid;


public class SingleResponsbilty {


}

// here good example of Single Responsbilty Solid Principle
class LoadServices {
    public void createLoan() {
//        code...
        System.out.println("Loan Created");
    }

    public void closeLoan() {
//        code...
        System.out.println("Loan closed");
    }
}

class CommunicationServices{
    public void sendCommunication() {
//        code...
        System.out.println("send communication to customer / bankers..!");
    }
    public void createCommunication() {
//        code...
        System.out.println("create communication to customer / bankers..!");
    }
}

class AccountServices{
    public void createAccount() {
//        code...
        System.out.println("Account Created..!");
    }
    public void CloseAccount() {
//        code...
        System.out.println("Account Closed..!");
    }

}

//Bad class because it is backing single responsbilty solid principle
class BankServices {
    public void createAccount() {
//        code..
        System.out.println("Account Created");
    }

    public void createLoan() {
//        code...
        System.out.println("Loan Created");
    }

    public void sendCommunication() {
//        code...
        System.out.println("send communication to customer and bankers..!");
    }

}