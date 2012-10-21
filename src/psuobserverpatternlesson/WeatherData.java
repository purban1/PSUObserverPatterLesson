package psuobserverpatternlesson;

import java.util.*;

public class WeatherData implements Subject {

    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        // verify the input
        observers = new ArrayList();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        // verify the inputs
        setTemperature(temperature);
        setHumidity(humidity);
        setPressure(pressure);
        measurementChanged();
    }

    @Override
    public void registerObserver(Observer obs) {
        // verify the input
        this.observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        // verify the input
        int i = observers.indexOf(obs);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    private void measurementChanged() {
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < this.observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * @return the observers
     */
    public ArrayList getObservers() {
        return observers;
    }

    /**
     * @param observers the observers to set
     */
    public void setObservers(ArrayList observers) {
        // verify the input
        this.observers = observers;
    }

    /**
     * @return the temperature
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    private void setTemperature(float temperature) {
        // verify the input
        this.temperature = temperature;
    }

    /**
     * @return the humidity
     */
    public float getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    private void setHumidity(float humidity) {
        // verify the input
        this.humidity = humidity;
    }

    /**
     * @return the pressure
     */
    private float getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    private void setPressure(float pressure) {
        // verify the input
        this.pressure = pressure;
    }
}
