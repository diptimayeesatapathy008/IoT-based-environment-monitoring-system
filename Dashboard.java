import java.util.List;

public class Dashboard {
    private List<String> locations;

    public Dashboard(List<String> locations) {
        this.locations = locations;
    }

    // Method to display real-time data on the dashboard
    public void displayRealTimeData(SensorData data) {
        System.out.println("Real-Time Data: " + data.toString());
    }

    // Method to display historical trends on the dashboard
    public void displayHistoricalTrends(List<SensorData> historicalData) {
        System.out.println("Historical Data Trends:");
        for (SensorData data : historicalData) {
            System.out.println(data.toString());
        }
    }
}