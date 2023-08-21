package br.com.thalleseduardo.cityweather.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherInfoTest {

    @Test
    void testDescription(){
        WeatherInfo weatherInfo = new WeatherInfo();

        String description = "Clear sky";
        weatherInfo.setDescription(description);

        assertEquals(description, weatherInfo.getDescription());
    }
}
