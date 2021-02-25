package atm.transaction;

import atm.ATM;
import atm.Session;
import atm.physical.*;
import banking.AccountInformation;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Status;
import banking.Receipt;

/**
 * @author Budiman Rasyid
 */
/**
 * class untuk transaksi penarikan tunai
 */
public class Withdrawal extends Transaction {
    /**
     * Constructor
     * @param atm ATM yang sedang digunakan oleh pengguna
     * @param session sesi transaksi yang sedang berlangsung
     * @param card kartu pengguna
     * @param pin PIN pengguna
     */
    public Withdrawal(ATM atm, Session session, Card card, int pin) {
        super(atm, session, card, pin);
    }

    /**
     * menu spesifik dari transaksi penarikan tunai oleh pengguna
     * @return membalikan nilai pada class bank untuk memulai transaksi
     * @throws atm.physical.CustomerConsole.Cancelled jika pengguna membatalkan transaksi
     */
    @Override
    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled {
        from = atm.getCustomerConsole().readMenuChoice(
                "Tarik tunai dari",
                AccountInformation.ACCOUNT_NAMES);

        String[] amountOptions = {"Rp 50.000",
                "Rp 100.000",
                "Rp 150.000",
                "Rp 200.000",
                "Rp 250.000"
        };
        Money[] amountValues = {
                new Money(50000), new Money(100000), new Money(150000),
                new Money(200000), new Money(250000), new Money(0)
        };

        String amountMessage = "";
        boolean validAmount = false;

        while (!validAmount) {
            amount = amountValues[atm.getCustomerConsole().readMenuChoice(
                    amountMessage + "Pilih jumlah tarik tunai", amountOptions)];

            validAmount = atm.getCashDispenser().checkCashOnHand(amount);

            if (!validAmount) {
                amountMessage = "Insufficient cash available\n";
            }
        }

        return new Message(Message.WITHDRAWAL,
                card, pin, serialNumber, from, -1, amount);

    }

    /**
     * Mengakhiri transaksi yang sudah disetujui
     * @return untuk mencetak struk saat transaksi selesai
     */

    protected Receipt completeTransaction() {
        atm.getCashDispenser().dispenseCash(amount);
        return new Receipt(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[2];
                detailsPortion[0] = "TARIK TUNAI DARI: "
                        + AccountInformation.ACCOUNT_ABBREVIATIONS[from];
                detailsPortion[1] = "JUMLAH: " + amount.toString();
            }
        };
    }

    /**
     * Akun tang melakukan transaksi tarik tunai
     */
    private int from;


    /**
     * Jumlah uang yang ditarik pada transaksi tarik tunai
     */
    private Money amount;
}