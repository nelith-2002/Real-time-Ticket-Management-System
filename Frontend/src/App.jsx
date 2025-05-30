import TicketConfig from "./components/TicketConfig";
import TicketDisplay from "./components/TicketDisplay";
import "./App.css"

function App() {
  return (
    <div className="container">
      <h1>🎟️ Ticketing System Control</h1>
      <TicketConfig />
      <TicketDisplay />
    </div>
  );
}

export default App;
