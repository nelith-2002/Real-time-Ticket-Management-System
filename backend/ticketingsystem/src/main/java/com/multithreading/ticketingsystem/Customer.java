package com.multithreading.ticketingsystem;


import java.util.concurrent.CountDownLatch;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int retrievalRate;
    private final int totalTickets;


//    private static int purchasedTickets = 0;

    public Customer(TicketPool ticketPool, int retrievalRate, int totalTickets) {
        this.ticketPool = ticketPool;
        this.retrievalRate = retrievalRate;
        this.totalTickets = totalTickets;
    }

    @Override
    public void run() {
        for (int i = 0; i <= retrievalRate ; i++) {
            try {
                if (!ticketPool.getTicketPool().isEmpty()) {
                    ticketPool.removeTicket();

                    Thread.sleep(2000 );

                }
                //System.out.println(Thread.currentThread().getName() + " finished purchasing tickets.");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
