package com.multithreading.ticketingsystem.Configuration;


import org.springframework.stereotype.Component;


@Component
public class ConfigurationForm {
    private int totalTickets;          // Total number of tickets in the system
    private int ticketReleaseRate;    // Rate at which tickets are released by the vendor
    private int customerRetrievalRate; // Rate at which customers retrieve tickets
    private int maxTicketCapacity;     // Maximum number of tickets allowed in the pool


    // Default constructor (required for Gson)
    public ConfigurationForm() {}


    // Parameterized constructor
    public ConfigurationForm(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;

    }



    // Getters and Setters for all fields
    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        if (totalTickets <= 0) {
            throw new IllegalArgumentException("Total tickets must be greater than 0");

        }
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        if (ticketReleaseRate <= 0) {
            throw new IllegalArgumentException("Ticket release rate must be greater than 0.");
        }
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        if (customerRetrievalRate <= 0) {
            throw new IllegalArgumentException("Customer retrieval rate must be greater than 0.");
        }
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        if (maxTicketCapacity <= 0) {
            throw new IllegalArgumentException("Maximum ticket capacity must be greater than 0.");
        }
//        if (maxTicketCapacity < totalTickets) {
//            throw new IllegalArgumentException("Maximum ticket capacity must be greater than or equal to total tickets.");
//        }
        this.maxTicketCapacity = maxTicketCapacity;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                '}';
    }

}
