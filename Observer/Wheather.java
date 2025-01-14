package Observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String weather);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
    // Add setWeather to the interface if it is essential for all subjects
    void setWeather(String newWeather);
}

// Concrete class

class WeatherStataion implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String weather;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(weather);
        }
    }

    @Override
    public void setWeather(String newWeather) {
        this.weather = newWeather;
        notifyObserver();
    }
}

class PhoneDisplay implements Observer {
    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    private void display() {
        System.out.println("Phone Display: " + weather);
    }
}

public class Wheather {
    public static void main(String[] args) {
        WeatherStataion weatherStataion = new WeatherStataion();

        Observer phoneDisplay = new PhoneDisplay();

        weatherStataion.addObserver(phoneDisplay); // Add observer to weather station
        weatherStataion.setWeather("hot"); // Change weather to notify observers
    }
}
