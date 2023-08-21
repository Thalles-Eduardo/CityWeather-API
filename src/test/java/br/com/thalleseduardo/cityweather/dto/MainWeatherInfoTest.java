package br.com.thalleseduardo.cityweather.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainWeatherInfoTest {

    @Test
    void testTempFormatted(){
        MainWeatherInfo mainWeatherInfo = new MainWeatherInfo();

        double temp = 290.0; // Kelvin
        String formattedTemp = mainWeatherInfo.tempFormatted(temp);

        assertEquals("16°C or 62°F", formattedTemp);
    }
}
