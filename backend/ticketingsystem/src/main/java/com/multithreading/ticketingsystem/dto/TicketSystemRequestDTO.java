package com.multithreading.ticketingsystem.dto;



public class TicketSystemRequestDTO {

    private int totalTickets;          // Total tickets in the system
    private int ticketReleaseRate;     // Tickets released per second by vendors
    private int customerRetrievalRate; // Tickets retrieved per second by customers
//    private int vendorCount;           // Number of vendor threads
//    private int customerCount;         // Number of customer threads

    private int maxTicketCapacity;


    // Getters and Setters
    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

//    public int getVendorCount() {
//        return vendorCount;
//    }
//
//    public void setVendorCount(int vendorCount) {
//        this.vendorCount = vendorCount;
//    }
//
//    public int getCustomerCount() {
//        return customerCount;
//    }
//
//    public void setCustomerCount(int customerCount) {
//        this.customerCount = customerCount;
//    }


    public int getMaxTicketCapacity() {
        return 0;
    }
}
