
import java.util.*;

/**
 * 
 */
public class Inquiry extends Transaction {

    /**
     * Default constructor
     */
    public Inquiry() {
    }

    /**
     * 
     */
    private int from;

    /**
     * @param atm 
     * @param session 
     * @param card 
     * @param pin
     */
    public void Inquiry(ATM atm, Session session, Card card, int pin) {
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