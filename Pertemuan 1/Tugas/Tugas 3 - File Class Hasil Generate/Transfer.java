
import java.util.*;

/**
 * 
 */
public class Transfer extends Transaction {

    /**
     * Default constructor
     */
    public Transfer() {
    }

    /**
     * 
     */
    private int from;

    /**
     * 
     */
    private int to;

    /**
     * 
     */
    private Money amount;

    /**
     * @param atm 
     * @param session 
     * @param card 
     * @param pin
     */
    public void Transfer(ATM atm, Session session, Card card, int pin) {
        // TODO implement here
    }

    /**
     * @return
     */
    protected Message throws Cancelled getSpecificsFromCustomer() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    protected Receipt completeTransaction() {
        // TODO implement here
        return null;
    }

}