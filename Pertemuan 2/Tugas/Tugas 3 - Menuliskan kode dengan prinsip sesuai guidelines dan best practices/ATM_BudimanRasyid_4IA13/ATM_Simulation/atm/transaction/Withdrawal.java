package atm.transaction;

import atm.ATM;
import atm.Session;
import atm.physical.CustomerConsole;
import banking.AccountInformation;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Receipt;

public class Withdrawal extends Transaction {

    public Withdrawal(ATM atm, Session session, Card card, int pin) {
        super(atm, session, card, pin);
    }

    @Override
    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled {
        from = atm.getCustomerConsole().readMenuChoice("Tarik Tunai Dari", AccountInformation.ACCOUNT_NAMES);

        String[] amountOptions = { "Rp 50.0000", "Rp 100.0000", "Rp 150.0000", "Rp 200.0000", "Rp 250.0000", };
        Money[] amountValue = { new Money(50000), new Money(100000), new Money(150000), new Money(200000),
                new Money(250000), };
        String amountMessage = "";
        boolean validAmount = false;
        while (!validAmount) {
            amount = amountValue[atm.getCustomerConsole().readMenuChoice("Pilih Jumlah Tarik Tunai", amountOptions)];
            validAmount = atm.getCashDispenser().checkCashOnHand(amount);
            if (!validAmount) {
                amountMessage = "Tidak dapat melakukan transaksi";
            }
        }
        return new Message(Message.WITHDRAWAL, card, pin, serialNumber, from, -1, amount);
    }

    @Override
    protected Receipt completeTransaction() throws CustomerConsole.Cancelled {
        atm.getCashDispenser().dispenseCash(amount);
        return new Receipt(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[2];
                detailsPortion[0] = "TARIK TUNAI DARI: " + AccountInformation.ACCOUNT_ABBREVIATIONS[from];
                detailsPortion[1] = "JUMLAH: " + amount.toString();
            }
        };
    }

    private int from;
    private Money amount;
}