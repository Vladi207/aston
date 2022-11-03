package org.github.grashchenko.designePatterns.state;

public class NoDebitCardState implements AtmState {

    @Override
    public void insertDebitCard() {
        System.out.println("DebitCard inserted ....");

    }

    @Override
    public void ejectDebitCard() {

        System.out.println("No Debit Card in ATM Machine slot, so you cannot eject the Debit Card...");
    }

    @Override
    public void enterPinAndWithdrawMoney(int pin, int amount) {
        System.out.println("No Debit Card in ATM Machine slot, so you cannot enter the pin and withdraw the money...");

    }
}
