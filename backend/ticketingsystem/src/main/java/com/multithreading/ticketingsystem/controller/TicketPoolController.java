package com.multithreading.ticketingsystem.controller;

import com.multithreading.ticketingsystem.Configuration.ConfigService;
import com.multithreading.ticketingsystem.Configuration.ConfigurationForm;
import com.multithreading.ticketingsystem.service.TicketPoolService;
import com.multithreading.ticketingsystem.dto.TicketSystemRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ticket-system")
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from the React app
public class TicketPoolController {

    private final TicketPoolService ticketPoolService;


    @Autowired
    public TicketPoolController(TicketPoolService ticketPoolService) {
        this.ticketPoolService = ticketPoolService;

    }


    @PostMapping("/start")
    public String startSystem() throws InterruptedException {
        // Save the configuration to a JSON file

        ticketPoolService.startSystem();
        return "Ticketing system started successfully.";
    }

    /**
     * Endpoint to stop the ticketing system.
     *
     * @return Response message indicating the system has stopped.
     */
    @PostMapping("/stop")
    public String stopSystem() {
        ticketPoolService.stopSystem();
        return "Ticketing system stopped successfully.";
    }







}
