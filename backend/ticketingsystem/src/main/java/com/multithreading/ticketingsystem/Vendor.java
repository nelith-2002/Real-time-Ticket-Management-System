package com.multithreading.ticketingsystem;

import com.multithreading.ticketingsystem.service.TicketPoolService;

import org.springframework.stereotype.Component;


public class Vendor implements Runnable{

    private TicketPool ticketPool;
    private int ticketReleaseRate;
    private int totalTickets;

    private static int ticketCounter = 0;

    public static int getTicketCounter() {
        return ticketCounter;
    }

    private static int finishedVendors = 0; // Shared counter for finished vendors
    private static final Object lock = new Object(); // Lock for synchronization

    private TicketPoolService ticketPoolService;


    public void vendor(TicketPool ticketPool, int ticketReleaseRate, int totalTickets) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
    }

    public Vendor(TicketPool ticketPool, int ticketReleaseRate, int totalTickets) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= ticketReleaseRate; i++) {
                //System.out.println(ticketPoolService.getTicketReleaseRate());

                synchronized (lock) {
                    if (ticketCounter >= totalTickets) break; // Stop if all tickets are added
                     ticketCounter++;
                    String ticket = "Ticket-" + ticketCounter;
                    ticketPool.addTicket(ticket); // Add ticket to the pool
                    System.out.println(Thread.currentThread().getName() + " added: " + ticket);
                }
//                Thread.sleep(3000 / ticketReleaseRate); // Control release rate
                Thread.sleep(1500 ); // Control release rate

            }
            //System.out.println(Thread.currentThread().getName() + " has finished adding tickets.");

            synchronized (lock) {
                finishedVendors++; // Increment finished vendor counter
                if (finishedVendors == 2) { // Assuming there are 2 vendor threads
                    System.out.println("All vendors have finished adding tickets to the pool.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }














}
