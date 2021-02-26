/**
 * @author Budiman Rasyid
 */
public class TicketCounter {
    int availableSeats = 3;

    /**
     * Sebuah method untuk booking ticket
     *
     * @param name          parameter untuk nama yang booking
     * @param numberOfSeats parameter untuk tempat duduk yang akan dibooking
     */
    void bookTicket(String name, int numberOfSeats) {
        if ((availableSeats >= numberOfSeats) && (numberOfSeats > 0)) {
            System.out.println("Available Ticket = " + availableSeats);
            System.out.println("Hi, " + name + ": " + numberOfSeats + " Seats book Successfully...");
            availableSeats = availableSeats - numberOfSeats;
        } else {
            System.out.println("Available Ticket = " + availableSeats);
            System.out.println("Sorry, " + name + " : Seats Not Available");
        }
    }

    /**
     * Sebuah method untuk menambahkan ticket
     *
     * @param dropedTicket parameter untuk menambahkan ticket
     */
    void dropTicket(int dropedTicket) {
        if (availableSeats == 0) {
            availableSeats = availableSeats + dropedTicket;
            // System.out.println("Available Ticket = " + availableSeats);
            System.out.println(availableSeats + " ticket(s) have been added");
        }
    }
}
