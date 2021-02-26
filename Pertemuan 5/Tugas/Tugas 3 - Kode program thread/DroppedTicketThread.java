/**
 * @author Budiman Rasyid
 */
public class DroppedTicketThread extends Thread {

    TicketCounter tc;
    int seats;

    /**
     * @param tc    parameter untuk class TicketCounter
     * @param seats parameter untuk tempat duduk
     */
    DroppedTicketThread(TicketCounter tc, int seats) {
        this.tc = tc;
        this.seats = seats;
    }

    /**
     * Method untuk menjalankan perintah synchronized pada class DroppedTicketThread
     */
    @Override
    public void run() {
        synchronized (tc) {
            tc.dropTicket(seats);
        }
    }
}
