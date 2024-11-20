package Week5.A52_Synchronization.Task1;

public class Customer implements Runnable {
    private String name;
    private int tickets;
    private Reservation reservation;

    public Customer(String name, int tickets, Reservation reservation) {
        this.name = name;
        this.tickets = tickets;
        this.reservation = reservation;
    }

    @Override
    public void run() {
        reservation.reserve(this);
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public String getName() {
        return name;
    }

    public int getTickets() {
        return tickets;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer " + this.name;
    }
}
