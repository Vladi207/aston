package org.github.grashchenko.designePatterns.state;

public interface AtmState {
    public void insertDebitCard();

    public void ejectDebitCard();

    public void enterPinAndWithdrawMoney(int pin, int amount);
}
