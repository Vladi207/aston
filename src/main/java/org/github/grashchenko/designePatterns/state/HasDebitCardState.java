package org.github.grashchenko.designePatterns.state;

public class HasDebitCardState implements AtmState {

    @Override
    public void insertDebitCard() {
        System.out.println("Debit Card is already there,So you cannot insert the Debit Card ...");

    }

    @Override
    public void ejectDebitCard() {

        System.out.println("Debit Card is ejected...");
    }

    @Override
    public void enterPinAndWithdrawMoney(int pin, int amount) {
        verifyPin(pin);
        verifyAmount(amount);
        System.out.println("money has been withdrawn...");

    }

    public void verifyPin(int pin) {
        System.out.println("Pin number has been entered correctly");
    }

    public void verifyAmount(int amount) {
        if (amount <= 0) {
            System.out.println( "Amount cannot less than or equal to zero");
            System.exit(1);}
        if (amount % 20 != 0) {
            System.out.println("Please enter amount in mulitples of 20");
            System.exit(1);}

        System.out.println( "You have entered "+amount);

    }
}
