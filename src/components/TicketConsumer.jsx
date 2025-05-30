import React from "react";

function TicketConsumer() {
  const consumeTickets = () => {
    console.log("Consuming tickets...");
  };

  return (
    <div className="card">
      <h2>Ticket Consumer</h2>
      <button className="button" onClick={consumeTickets}>
        Consume Tickets
      </button>
    </div>
  );
}

export default TicketConsumer;
