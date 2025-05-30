package com.multithreading.ticketingsystem.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.module.Configuration;



@Service
public class ConfigService {

    private static final String CONFIG_FILE = "config.json"; // Path to store the configuration file
    private static final String CONFIG_TEXT_FILE = "config.txt"; // Path to store the text configuration file


    // Method to save configuration to a JSON file
    public void saveConfiguration(ConfigurationForm config) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Gson instance with pretty printing

        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            gson.toJson(config, writer);  // Convert Configuration object to JSON and write to the file
            System.out.println("Configuration saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving configuration: " + e.getMessage());
        }
        saveConfigurationAsText(config); // Save the same data in text format
    } 

    // Method to save configuration to a text file
    private void saveConfigurationAsText(ConfigurationForm config) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONFIG_TEXT_FILE))) {
            writer.write("Configuration Details- \n");
            writer.write("Total Tickets: " + config.getTotalTickets()+"\n");
            writer.write("Ticket Release Rate: " + config.getTicketReleaseRate()+"\n");
            writer.write("Customer Retrieval Rate: " + config.getCustomerRetrievalRate()+"\n");
            writer.write("Max Ticket Capacity: " + config.getMaxTicketCapacity()+"\n");
            System.out.println("Configuration saved successfully as Text."+"\n");
        } catch (IOException e) {
            System.out.println("Error saving configuration as Text: " + e.getMessage());
        }
    }

    // Method to load configuration from a JSON file
    public static ConfigurationForm loadConfiguration() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            // Convert JSON in the file to a Configuration object
//            Configuration config = gson.fromJson(reader, Configuration.class);
//            return config;
            return gson.fromJson(reader, ConfigurationForm.class);


        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
            return new ConfigurationForm(); // Return null if loading fails
        }
    }









    }

