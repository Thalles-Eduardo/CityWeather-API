package br.com.thalleseduardo.cityweather.controller;

import br.com.thalleseduardo.cityweather.dto.MainWeatherInfo;
import br.com.thalleseduardo.cityweather.dto.WeatherDTO;
import br.com.thalleseduardo.cityweather.dto.WeatherInfo;
import br.com.thalleseduardo.cityweather.exception.customexception.NotFoundException;
import br.com.thalleseduardo.cityweather.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetWeather_ValidCityName() {
        String cityName = "SampleCity";
        WeatherDTO mockWeatherDTO = createMockWeatherDTO();

        when(weatherService.getWeatherData(cityName)).thenReturn(mockWeatherDTO);

        Map<String, Object> result = weatherController.getWeather(cityName);

        assertEquals(mockWeatherDTO.getName(), result.get("City name"));
        assertEquals(mockWeatherDTO.getWeather().get(0).getDescription(), result.get("Description"));
        assertEquals(mockWeatherDTO.getMain().getTemp(), result.get("Temperature"));
        assertEquals(mockWeatherDTO.getMain().getTemp_max(), result.get("Max. temperature"));
        assertEquals(mockWeatherDTO.getMain().getTemp_min(), result.get("Min. temperature"));

        verify(weatherService, times(1)).getWeatherData(cityName);
    }

    @Test
    void testGetWeather_InvalidCityName() {
        String invalidCityName = "InvalidCity";

        when(weatherService.getWeatherData(invalidCityName)).thenThrow(new NotFoundException("Cidade inválida!"));

        assertThrows(NotFoundException.class, () -> weatherController.getWeather(invalidCityName));

        verify(weatherService, times(1)).getWeatherData(invalidCityName);
    }

    private WeatherDTO createMockWeatherDTO() {
        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setName("SampleCity");

        MainWeatherInfo mainWeatherInfo = new MainWeatherInfo();
        mainWeatherInfo.setTemp(300);
        mainWeatherInfo.setTemp_max(305);
        mainWeatherInfo.setTemp_min(295);

        List<WeatherInfo> weatherInfoList = new ArrayList<>();
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setDescription("Sample Weather Description");
        weatherInfoList.add(weatherInfo);

        weatherDTO.setMain(mainWeatherInfo);
        weatherDTO.setWeather(weatherInfoList);

        return weatherDTO;
    }
}
