package com.pp.sun.finctional_lambada;

@FunctionalInterface
interface RBI{
    Double showDebitedAmount(Double amount);
    // Exception :
//    java: Unexpected @FunctionalInterface annotation
//    com.pp.sun.finctional_lambada.RBI is not a functional interface
//    multiple non-overriding abstract methods found in interface com.pp.sun.finctional_lambada.RBI
//    String showAddressOfHeadOffice(String sddress); // Exception

    static void showBankName(){
        System.out.println("RBI Indian Bank of Father...! ");
    }
    default Double showMinBalnace (){
        System.out.println("RBI Min Amount ran ...! ");
        return 123456.0846;
    }

}

@FunctionalInterface
interface AEXP extends RBI{
       double  addOfDepositAmound = 10003455.76;

    Double showDebitedAmount(Double amount);// EXC: voilate the functional Interface rules

    static void showBankName(){
        System.out.println("American Bank AEXP...! ");
    }
    default Double showMinBalnace (){
        System.out.println("AEXP Min Amount ran ...! ");
        return 1000000.0846;
    }
}

public class FuncionalIntrefaceWithLambadaExp {
    public  static double  addOfDepositAmound = 10003455.76;
    AEXP aexpwihAdd = depositAmount-> {
        Double thisV = this.addOfDepositAmound ;
        return (depositAmount+thisV);
    };
//    double aexpwihAdd= this.aexpwihAdd.showDebitedAmount(37774.88);
    public static void main(String[] args) {

        // given implimentation and call functional interface abstract methods
        RBI rbiT1 = (depositAmount)-> depositAmount;
        AEXP aexp = depositAmount-> depositAmount;

//        System.out.println("aexpwihAdd.showDebitedAmount: "+aexpwihAdd);
        System.out.println("rbiT1.showDebitedAmount: "+rbiT1.showDebitedAmount(1000.34));

        //Call Static method from Functional Interface
        RBI.showBankName();

        //Call default methods of the functional Interface
      Double minBal=  rbiT1.showMinBalnace();
        System.out.println(minBal);


        System.out.println("aexp.showDebitedAmount: "+aexp.showDebitedAmount(1000.34));
        //Call Static method from Functional Interface
        AEXP.showBankName();

        //Call default methods of the functional Interface
        Double rbimin=  rbiT1.showMinBalnace();
        Double aexpmin=  aexp.showMinBalnace();
        System.out.println("rbimin"+rbimin);
        System.out.println("aexpmin"+aexpmin);

    }
}
