package com.multithreading.ticketingsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Define the TicketPool bean with maxCapacity
    @Bean
    public TicketPool ticketPool() {
        int maxCapacity = 10; // Default value or dynamically set
        return new TicketPool(maxCapacity);
    }
}
