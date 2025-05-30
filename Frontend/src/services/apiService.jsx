import axios from "axios";

const BASE_URL = "http://localhost:8080"; // Backend base URL

// Save configuration
export const saveConfiguration = async (config) => {
  try {
    const response = await axios.post(`${BASE_URL}/config/save`, config);
    return response.data;
  } catch (error) {
    console.error("Error saving configuration:", error);
    throw error;
  }
};

// Start the system
export const startSystem = async () => {
  try {
    const response = await axios.post(`${BASE_URL}/ticket-system/start`);
    return response.data;
  } catch (error) {
    console.error("Error starting the system:", error);
    throw error;
  }
};

// Stop the system
export const stopSystem = async () => {
  try {
    const response = await axios.post(`${BASE_URL}/ticket-system/stop`);
    return response.data;
  } catch (error) {
    console.error("Error stopping the system:", error);
    throw error;
  }
};
