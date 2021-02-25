
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
 * class untuk transaksi transfer
 */
public class Transfer extends Transaction // Representasi untuk transaksi transfer
{
    /**
     *
     * @param atm ATM yang digunakan untuk berkomunikasi dengan nasabah
     * @param session Session di mana transaksi ini dilakukan
     * @param card pelanggan
     * @param pin PIN yang dimasukkan oleh nasabah
     */
    public Transfer(ATM atm, Session session, Card card, int pin)
    {
        super(atm, session, card, pin);
    }



    /**
     * getSpecificsFromCustomer() : Dapatkan Data spesifik untuk transaksi dari pelanggan
     * Returns: pesan ke bank untuk memulai transaksi ini
     * Throws: CustomerConsole. Dibatalkan jika pelanggan membatalkan transaksi ini
     * Overrides:getSpecificsFromCustomer di kelas Transaksi
     *
     */
    @Override
    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled
    {
        from = atm.getCustomerConsole().readMenuChoice(
                "Transfer dari rekening:",
                AccountInformation.ACCOUNT_NAMES);

        to = atm.getCustomerConsole().readMenuChoice(
                "Pilih rekening tujuan",
                AccountInformation.ACCOUNT_BANK);

        amount = atm.getCustomerConsole().readAmount("Masukan jumlah yang ingin ditransfer");

        return new Message(Message.TRANSFER,
                card, pin, serialNumber, from, to, amount);
    }

    /**
     * protected Receipt completeTransaction() : Selesaikan transaksi yang disetujui
     * Returns: struk yang akan dicetak untuk transaksi ini
     * Overrides: completeTransaction in class Transaction
     */
    protected Receipt completeTransaction()
    {
        return new Receipt(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[2];
                detailsPortion[0] = "TRANSFER DARI: " +
                        AccountInformation.ACCOUNT_ABBREVIATIONS[from] +
                        "\n KE: " +
                        AccountInformation.ACCOUNT_ABBREVIATIONS[to] ;
                detailsPortion[1] = "Jumlah: " + amount.toString();
            }
        };
    }

    /**
     * private int from : Akun tempat transfer
     * private int to: Rekening tujuan transfer
     * private Money amoun: Jumlah uang yang akan ditransfer
     */
    private int from;

    private int to;

    private Money amount;
}