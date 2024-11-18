package Week5.A52_Synchronization;

public class Reservation {
    private int availableTickets;

    public Reservation(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public synchronized void reserve(Customer customer) {
        int result = 0;
        int requestedTicket = customer.getTickets();
        String ticketStr = " ticket";
        if (requestedTicket > 1) {
            ticketStr += "s";
        }
        if (requestedTicket <= 0) {
            System.out.println(customer + " couldn't reserve " + requestedTicket + ticketStr);
            // should return right away when there is not enough ticket
            return;

        }
        if (requestedTicket > this.availableTickets) {
            System.out.println(customer + " couldn't reserve " + requestedTicket + ticketStr);
            return;
        }
        this.availableTickets -= requestedTicket;
        customer.setTickets(requestedTicket);
        System.out.println(customer + " reserved " + requestedTicket + ticketStr);
//        return requestedTicket;
    }
}
