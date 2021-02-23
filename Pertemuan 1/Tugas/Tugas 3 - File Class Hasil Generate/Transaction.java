
import java.util.*;

/**
 * 
 */
public class Transaction {

    /**
     * Default constructor
     */
    public Transaction() {
    }

    /**
     * 
     */
    protected ATM atm;

    /**
     * 
     */
    protected Session session;

    /**
     * 
     */
    protected Card card;

    /**
     * 
     */
    protected int pin;

    /**
     * 
     */
    protected int serialNumber;

    /**
     * 
     */
    protected Message message;

    /**
     * 
     */
    protected Balances balances;

    /**
     * 
     */
    private final String TRANSACTION_TYPES_MENU;

    /**
     * 
     */
    private int nextSerialNumber;

    /**
     * 
     */
    private int state;

    /**
     * 
     */
    private final int GETTING_SPECIFICS_STATE;

    /**
     * 
     */
    private final int SENDING_TO_BANK_STATE;

    /**
     * 
     */
    private final int INVALID_PIN_STATE;

    /**
     * 
     */
    private final int COMPLETING_TRANSACTION_STATE;

    /**
     * 
     */
    private final int PRINTING_RECEIPT_STATE;

    /**
     * 
     */
    private final int ASKING_DO_ANOTHER_STATE;



    /**
     * @param atm 
     * @param session 
     * @param card 
     * @param pin
     */
    protected void Transaction(ATM atm, Session session, Card card, int pin) {
        // TODO implement here
    }

    /**
     * @param atm 
     * @param session 
     * @param card 
     * @param pin 
     * @return
     */
    public Transaction throws Cancelled makeTransaction(ATM atm, Session session, Card card, int pin) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean throws CardRetained performTransaction() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getSerialNumber() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    protected Receipt throws Cancelled completeTransaction() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    protected Message throws Cancelled getSpecificsFromCustomer() {
        // TODO implement here
        return null;
    }

}