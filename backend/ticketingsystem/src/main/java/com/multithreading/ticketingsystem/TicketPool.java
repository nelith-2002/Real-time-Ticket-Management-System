package com.multithreading.ticketingsystem;


import com.multithreading.ticketingsystem.Configuration.ConfigService;
import com.multithreading.ticketingsystem.Configuration.ConfigurationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;


public class TicketPool {

    private final Vector<String> ticketPool = new Vector<>();
    private int maxCapacity;
    private int totalTicketsAdded = 0;
    private int totalTicketsPurchased = 0;

    private int ticketCounter = 0;

    // Constructor to initialize the pool with a max capacity
    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }


    public Vector<String> getTicketPool() {
        return ticketPool;
    }

    // Add ticket to the pool
    public synchronized void addTicket(String ticket) {
//        while (ticketPool.size() >= maxCapacity) {
//            try {
//                System.out.println("Pool is full. Vendor is waiting to add tickets...");
//                wait();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                System.err.println("Thread interrupted while waiting to add tickets.");
//            }
//        }
        ticketPool.add(ticket);
        totalTicketsAdded++;
        System.out.println("Ticket added to the pool: " + ticket);
        notifyAll(); // Notify customers that a ticket is available
    }

    // Remove ticket from the pool
    public synchronized void removeTicket() {
        while (ticketPool.isEmpty()) {
            try {
//                System.out.println("Pool is empty. Customer is waiting for tickets...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted while waiting to remove tickets.");
            }
        }
        //String ticket = ticketPool.remove(0);
        System.out.println(Thread.currentThread().getName() + " purchased ticket: " + ticketPool.getFirst());
        ticketPool.remove(0);
        totalTicketsPurchased++;
        //System.out.println(Thread.currentThread().getName() + " purchased ticket: " + ticket);
        //notifyAll(); // Notify vendors that space is available
        //return ticket;
    }

    // Check if the ticketing process is complete
//    public synchronized boolean isCompleted(int totalTickets) {
//        return totalTicketsPurchased >= totalTickets;
//    }


}









