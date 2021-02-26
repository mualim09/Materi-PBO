/**
 * @author Budiman Rasyid
 */
public class TicketBookingThread extends Thread {
    TicketCounter tc;
    String name;
    int seats;

    /**
     * Sebuah class untuk booking ticket
     *
     * @param tc    parameter untuk class TicketCounter
     * @param name  parameter untuk nama yang memesan ticket
     * @param seats parameter untuk tempat duduk
     */
    TicketBookingThread(TicketCounter tc, String name, int seats) {
        this.tc = tc;
        this.name = name;
        this.seats = seats;
    }

    /**
     * Method untuk menjalankan perintah synchronized pada class TicketBookingThread
     */
    @Override
    public void run() {
        synchronized (tc) {
            tc.bookTicket(name, seats);
        }
    }
}
