package org.github.grashchenko.designePatterns.state;

public class Atm implements AtmState {

    private AtmState atmState;

    public Atm() {
        atmState = new NoDebitCardState();
    }

    public AtmState getAtmState() {
        return atmState;
    }

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }

    @Override
    public void insertDebitCard() {

        atmState.insertDebitCard();


        if( atmState instanceof NoDebitCardState )
        {

            AtmState hasDebitCardState = new HasDebitCardState();
            setAtmState(hasDebitCardState);
            System.out.println("ATM Machine internal state has been moved to : "
                    + atmState.getClass().getName());
        }
    }

    @Override
    public void ejectDebitCard() {

        atmState.ejectDebitCard();

        if( atmState instanceof HasDebitCardState )
        {

            AtmState noDebitCardState = new NoDebitCardState();
            setAtmState(noDebitCardState);
            System.out.println("ATM Machine internal state has been moved to : "
                    + atmState.getClass().getName());
        }
    }

    @Override
    public void enterPinAndWithdrawMoney(int pin, int amount) {
        atmState.enterPinAndWithdrawMoney(pin, amount);
    }
}
