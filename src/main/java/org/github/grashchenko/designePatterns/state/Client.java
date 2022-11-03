package org.github.grashchenko.designePatterns.state;

public class Client {
    public static void main( String[] args ) {

        Atm atm = new Atm();


        System.out.println("ATM Machine Current state : "
                + atm.getAtmState().getClass().getName());

        System.out.println();
        atm.enterPinAndWithdrawMoney(1234, 20);
        atm.ejectDebitCard();
        atm.insertDebitCard();

        System.out.println("\n*******************************************************");

        System.out.println("\nATM Machine Current state : "
                + atm.getAtmState().getClass().getName());
        System.out.println();

        atm.enterPinAndWithdrawMoney(1234, 20);
        atm.insertDebitCard();
        atm.ejectDebitCard();
        System.out.println("\n*******************************************************");


        System.out.println("\nATM Machine Current state : "
                + atm.getAtmState().getClass().getName());

    }
}
