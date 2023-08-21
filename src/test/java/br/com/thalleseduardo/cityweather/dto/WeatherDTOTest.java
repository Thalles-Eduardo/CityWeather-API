package br.com.thalleseduardo.cityweather.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherDTOTest {

    @Test
    void weatherDTOTest(){
        WeatherDTO weatherDTO = new WeatherDTO();
        WeatherInfo weatherInfo = new WeatherInfo();
        MainWeatherInfo mainWeatherInfo = new MainWeatherInfo();

        String cityName = "London";
        weatherDTO.setName(cityName);

        String description = "Clear sky";
        weatherInfo.setDescription(description);

        double tempMax = 300; // Kelvin
        mainWeatherInfo.setTemp_max(tempMax);


        assertEquals(cityName, weatherDTO.getName());
        assertEquals(description, weatherInfo.getDescription());
        assertEquals("26°C or 80°F", mainWeatherInfo.getTemp_max());

    }
}
