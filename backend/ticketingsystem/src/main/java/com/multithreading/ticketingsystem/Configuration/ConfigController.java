package com.multithreading.ticketingsystem.Configuration;

import com.multithreading.ticketingsystem.Configuration.ConfigService;
import com.multithreading.ticketingsystem.Configuration.ConfigurationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private final ConfigService configService;

    @Autowired
    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @PostMapping("/save")
    public String saveConfiguration(@RequestBody ConfigurationForm configuration) {
        configService.saveConfiguration(configuration);
        return "Configurations saved successfully.";

    }

}
