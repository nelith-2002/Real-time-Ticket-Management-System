import { useState } from "react";
import { saveConfiguration, startSystem, stopSystem } from "../services/apiService.jsx";

function TicketConfig() {
  const [totalTickets, setTotalTickets] = useState("");
  const [releaseRate, setReleaseRate] = useState("");
  const [retrievalRate, setRetrievalRate] = useState("");
  const [maxCapacity, setMaxCapacity] = useState("");

  const handleSave = async () => {
    const config = {
      totalTickets: Number(totalTickets),
      ticketReleaseRate: Number(releaseRate),
      customerRetrievalRate: Number(retrievalRate),
      maxTicketCapacity: Number(maxCapacity),
    };
    try {
      const response = await saveConfiguration(config);
      alert(response); // Show success message
    } catch (error) {
      alert("Failed to save configuration. Check console for details.");
    }
  };

  const handleStart = async () => {
    try {
      const response = await startSystem();
      alert(response); // Show success message
    } catch (error) {
      alert("Failed to start the system. Check console for details.");
    }
  };

  const handleStop = async () => {
    try {
      const response = await stopSystem();
      alert(response); // Show success message
    } catch (error) {
      alert("Failed to stop the system. Check console for details.");
    }
  };

  return (
    <div className="card">
      <h2>System Configuration</h2>
      <label>
        Total Tickets
        <input
          type="number"
          placeholder="Enter total tickets"
          value={totalTickets}
          onChange={(e) => setTotalTickets(e.target.value)}
        />
      </label>
      <label>
        Ticket Release Rate
        <input
          type="number"
          placeholder="Enter ticket release rate"
          value={releaseRate}
          onChange={(e) => setReleaseRate(e.target.value)}
        />
      </label>
      <label>
        Customer Retrieval Rate
        <input
          type="number"
          placeholder="Enter customer retrieval rate"
          value={retrievalRate}
          onChange={(e) => setRetrievalRate(e.target.value)}
        />
      </label>
      <label>
        Max Ticket Capacity
        <input
          type="number"
          placeholder="Enter max ticket capacity"
          value={maxCapacity}
          onChange={(e) => setMaxCapacity(e.target.value)}
        />
      </label>
      <button className="button start" onClick={handleSave}>
        Save Configuration
      </button>
      <button className="button start" onClick={handleStart}>
        Start System
      </button>
      <button className="button stop" onClick={handleStop}>
        Stop System
      </button>
    </div>
  );
}

export default TicketConfig;
