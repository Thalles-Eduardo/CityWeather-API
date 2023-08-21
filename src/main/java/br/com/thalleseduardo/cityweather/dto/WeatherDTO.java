package br.com.thalleseduardo.cityweather.dto;

import java.util.List;

public class WeatherDTO {
    private String name;
    private MainWeatherInfo main;
    private List<WeatherInfo> weather;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MainWeatherInfo getMain() {
        return main;
    }

    public void setMain(MainWeatherInfo main) {
        this.main = main;
    }

    public List<WeatherInfo> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherInfo> weather) {
        this.weather = weather;
    }
}
