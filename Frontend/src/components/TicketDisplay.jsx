import React, { useState } from "react";

function TicketDisplay() {
  const [ticketsLeft, setTicketsLeft] = useState(0);
  const [status, setStatus] = useState("Stopped");
  const [logs, setLogs] = useState([]);

  const addLog = (message) => {
    setLogs((prevLogs) => [...prevLogs, message]);
  };

  return (
    <div className="card">
      <h2>Total Tickets Left: {ticketsLeft}</h2>
      <h3>System Status: {status}</h3>
      <div className="log-box">
        {logs.map((log, index) => (
          <p key={index}>{log}</p>
        ))}
      </div>
    </div>
  );
}

export default TicketDisplay;
