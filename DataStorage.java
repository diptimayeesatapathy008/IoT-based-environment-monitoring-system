import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private Connection databaseConnection;

    // Constructor
    public DataStorage(String dbUrl, String user, String password) throws SQLException {
        this.databaseConnection = DriverManager.getConnection(dbUrl, user, password);
    }

    // Method to store sensor data in the database
    public void storeData(SensorData data) throws SQLException {
        String query = "INSERT INTO sensor_data (temperature, humidity, air_quality, timestamp) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setFloat(1, data.getTemperature());
            stmt.setFloat(2, data.getHumidity());
            stmt.setFloat(3, data.getAirQuality());
            stmt.setObject(4, data.getTimestamp());
            stmt.executeUpdate();
        }
    }

    // Method to fetch historical data from the database
    public List<SensorData> fetchHistoricalData(LocalDateTime start, LocalDateTime end) throws SQLException {
        String query = "SELECT temperature, humidity, air_quality, timestamp FROM sensor_data WHERE timestamp BETWEEN ? AND ?";
        List<SensorData> dataList = new ArrayList<>();
        try (PreparedStatement stmt = databaseConnection.prepareStatement(query)) {
            stmt.setObject(1, start);
            stmt.setObject(2, end);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    float temperature = rs.getFloat("temperature");
                    float humidity = rs.getFloat("humidity");
                    float airQuality = rs.getFloat("air_quality");
                    LocalDateTime timestamp = rs.getObject("timestamp", LocalDateTime.class);
                    dataList.add(new SensorData(temperature, humidity, airQuality));
                }
            }
        }
        return dataList;
    }
}
