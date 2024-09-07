public class Main {
    public static void main(String[] args) {
        // Simulate Sensor Data collection
        SensorData data = SensorData.getSensorData();

        // Store data in the database (Assume database connection details)
        try {
            DataStorage storage = new DataStorage("jdbc:mysql://localhost:3306/environment", "user", "password");
            storage.storeData(data);

            // Fetch and display historical data
            List<SensorData> historicalData = storage.fetchHistoricalData(LocalDateTime.now().minusDays(1), LocalDateTime.now());
            Dashboard dashboard = new Dashboard(Arrays.asList("Location1", "Location2"));
            dashboard.displayHistoricalTrends(historicalData);

            // Display real-time data
            dashboard.displayRealTimeData(data);

            // Send real-time updates to clients
            WebSocketServer server = new WebSocketServer();
            Client client1 = new Client("Client1");
            server.addClient(client1);
            server.sendRealTimeUpdates(data);

            // Check for any alerts
            NotificationService notificationService = new NotificationService();
            notificationService.checkThresholds(data);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}