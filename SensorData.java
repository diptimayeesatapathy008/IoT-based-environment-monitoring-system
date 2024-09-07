import java.time.LocalDateTime;

public class SensorData {
    private float temperature;
    private float humidity;
    private float airQuality;
    private LocalDateTime timestamp;

    // Constructor
    public SensorData(float temperature, float humidity, float airQuality) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.airQuality = airQuality;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(float airQuality) {
        this.airQuality = airQuality;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Method to simulate fetching data from sensors
    public static SensorData getSensorData() {
        // Here you would implement the actual sensor data fetching logic
        // For demonstration, we're returning dummy data
        return new SensorData(25.0f, 60.0f, 50.0f);
    }

    // Method to simulate sending data to the server
    public void sendDataToServer() {
        // Implementation for sending data to the server
        System.out.println("Data sent to server: " + this.toString());
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", airQuality=" + airQuality +
                ", timestamp=" + timestamp +
                '}';
    }
}

