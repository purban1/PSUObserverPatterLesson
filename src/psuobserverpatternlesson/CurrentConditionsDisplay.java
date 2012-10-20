package psuobserverpatternlesson;

public class CurrentConditionsDisplay implements Observer, DisplayElement{

    private float temperature;
    private float humidity;
    private Subject weatherData;
    
    public CurrentConditionsDisplay(Subject WeatherData){
        this.weatherData = WeatherData;
        this.weatherData.registerObserver(this);
    }
    
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + this.temperature +
                "°F and " + this.humidity + "% humidity.");
    }
    
}
