import java.util.ArrayList;
import java.util.List;

public class WebSocketServer {
    private List<Client> connectedClients;

    public WebSocketServer() {
        this.connectedClients = new ArrayList<>();
    }

    // Method to simulate sending real-time updates to connected clients
    public void sendRealTimeUpdates(SensorData data) {
        for (Client client : connectedClients) {
            client.receiveUpdate(data);
        }
    }

    // Method to add a client to the connectedClients list
    public void addClient(Client client) {
        connectedClients.add(client);
    }

    // Method to remove a client from the connectedClients list
    public void removeClient(Client client) {
        connectedClients.remove(client);
    }
}

// Client class for demonstration purposes
class Client {
    private String id;

    public Client(String id) {
        this.id = id;
    }

    public void receiveUpdate(SensorData data) {
        System.out.println("Client " + id + " received update: " + data.toString());
    }
}