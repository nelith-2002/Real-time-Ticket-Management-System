import React from "react";

function TicketProducer() {
  const produceTickets = () => {
    console.log("Producing tickets...");
  };

  return (
    <div className="card">
      <h2>Ticket Producer</h2>
      <button className="button" onClick={produceTickets}>
        Produce Tickets
      </button>
    </div>
  );
}

export default TicketProducer;
