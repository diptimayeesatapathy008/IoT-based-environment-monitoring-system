// Mock real-time data (in a real application, this data would come from your backend)
let currentData = {
    temperature: 22.5, // Celsius
    humidity: 55, // Percentage
    airQuality: 42 // AQI (Air Quality Index)
};

// Function to update the real-time data display
function updateRealTimeData() {
    document.getElementById('temperature').innerText = currentData.temperature + ' °C';
    document.getElementById('humidity').innerText = currentData.humidity + ' %';
    document.getElementById('air-quality').innerText = currentData.airQuality;
}

// Mock historical data for the chart (in a real application, this data would come from your backend)
let historicalData = {
    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
    temperature: [21, 22, 23, 22, 24, 25, 26],
    humidity: [50, 55, 53, 54, 56, 57, 58],
    airQuality: [40, 42, 44, 43, 45, 46, 47]
};

// Function to render the historical data chart
function renderHistoricalChart() {
    const ctx = document.getElementById('historicalChart').getContext('2d');
    new Chart(ctx, {
        type: 'line',
        data: {
            labels: historicalData.labels,
            datasets: [
                {
                    label: 'Temperature (°C)',
                    data: historicalData.temperature,
                    borderColor: 'rgba(255, 99, 132, 1)',
                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                    fill: true
                },
                {
                    label: 'Humidity (%)',
                    data: historicalData.humidity,
                    borderColor: 'rgba(54, 162, 235, 1)',
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    fill: true
                },
                {
                    label: 'Air Quality (AQI)',
                    data: historicalData.airQuality,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    fill: true
                }
            ]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

// Mock alerts data
let alerts = [
    'High Temperature Alert: Temperature exceeded 30°C',
    'Low Humidity Alert: Humidity dropped below 30%',
    'Poor Air Quality Alert: AQI exceeded 100'
];

// Function to update the alerts list
function updateAlerts() {
    const alertList = document.getElementById('alert-list');
    alerts.forEach(alert => {
        let listItem = document.createElement('li');
        listItem.innerText = alert;
        alertList.appendChild(listItem);
    });
}

// Initialize the dashboard
function initDashboard() {
    updateRealTimeData();
    renderHistoricalChart();
    updateAlerts();
}

// Run the dashboard initialization when the page loads
window.onload = initDashboard;
