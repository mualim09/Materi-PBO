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
 * class untuk transaksi cel saldo
 */
public class Inquiry extends Transaction // Membuat class dengan nama Inquiry dari class Transaction
{
    /**
     *
     * @param atm ATM yang sedang digunakan oleh pengguna
     * @param session Sesi yang sedang berlangsung melakukan transaksi
     * @param card Kartu pengguna yang akan melakukan transaksi
     * @param pin Pin pengguna yang akan melakukan transaksi
     */
    public Inquiry(ATM atm, Session session, Card card, int pin) // Membuat constructor dengan 4 parameter
    {
        super(atm, session, card, pin); // membuat super class dari Inquiry yang memiliki 4 parameter
    }

    /**
     * Menu spesifik dari transaksi cek saldo oleh pengguna
     * @return Mengembalikan nilai pada class Bank yang akan melakukan transaksi
     * @throws CustomerConsole.Cancelled Jika pengguna membatalkan transaksi cek saldo
     */
    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled // Mendapatkan Spesifik dari transaksi pelanggan secara spesifik
    {
        from = atm.getCustomerConsole().readMenuChoice( // mendapatkan data dari class ATM yang akan menampilkan pilihan menu di console, berupa
                "Cek Saldo pada rekening", // tampilan cek saldo pada rekening
                AccountInformation.ACCOUNT_NAMES); // dan menampilkan informasi akun berupa nama akun
        return new Message(Message.INQUIRY, card, pin, serialNumber, from, -1, new Money(0)); // mengembalikan sebuah nilai method class Message, yang berisikan beberapa parameter
    }

    /**
     * complete Transaction adalah untuk mengakhiri transaksi yang sedang disetujui yaitu cek saldonya berhasil maka ini akan dijalankan
     * @return untuk mencetak struk saat transaksi cek saldo telah selesai
     */
    protected Receipt completeTransaction() // membuat sebuah access modifier protected dengan nama Receipt completeTransaction
    {
        return new Receipt(this.atm, this.card, this, this.balances) { // Mengembalikan nilai baru dari method Receipt
            {
                detailsPortion = new String[2]; // membuat variable dengan data baru berupa String Array
                // Array dengan index 0 berisikan tulisan SALDO PADA REKENING + informasi akun
                detailsPortion[0] = "SALDO PADA REKENING: " + AccountInformation.ACCOUNT_ABBREVIATIONS[from];
                // Array dengan index 1 berisikan string kosong
                detailsPortion[1] = "";
            }
        };
    }

    /**
     * Akun tang melakukan transaksi tarik tunai
     */
    private int from; // membuat variable from dengan tipe data int, memiliki access modifier private

}