import java.util.concurrent.TimeUnit;

/**
 * @author Budiman Rasyid
 */
public class BookTicket {

    /**
     * Sebuah method main yang akan dijalankan pertama kali program apabila dijalankan
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        /**
         * Membuat sebuah variable baru yang diambil dari beberapa class
         */
        TicketCounter ticketCounter = new TicketCounter();
        TicketBookingThread t1 = new TicketBookingThread(ticketCounter, "Budiman", 3);
        TicketBookingThread t2 = new TicketBookingThread(ticketCounter, "Rasyid", 2);
        DroppedTicketThread dtt1 = new DroppedTicketThread(ticketCounter, 2);

        /**
         * Menjalankan thread pada variable t1, t2 dan dtt1
         * Serta menjalankan sebuah function untuk sleep sebesar 1 detik setiap kali thread dijalankan agar prosesnya
         * dapat ditunggu
         */
        t1.start();
//        TimeUnit.SECONDS.sleep(1);
        t2.start();
//        TimeUnit.SECONDS.sleep(1);
        dtt1.start();
//        TimeUnit.SECONDS.sleep(1);
    }

}