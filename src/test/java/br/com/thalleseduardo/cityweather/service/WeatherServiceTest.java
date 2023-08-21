package br.com.thalleseduardo.cityweather.service;

import br.com.thalleseduardo.cityweather.dto.WeatherDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WeatherServiceTest {

    private WeatherService weatherService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        weatherService = new WeatherService();
        weatherService.setRestTemplate(restTemplate);
    }

    @Test
    void testGetWeatherData_Success() {
        String cityName = "London";
        WeatherDTO expectedWeather = new WeatherDTO(); // You can create a sample WeatherDTO for testing

        ResponseEntity<WeatherDTO> responseEntity = ResponseEntity.ok(expectedWeather);
        when(restTemplate.getForEntity(anyString(), eq(WeatherDTO.class))).thenReturn(responseEntity);

        WeatherDTO result = weatherService.getWeatherData(cityName);

        assertEquals(expectedWeather, result);
        verify(restTemplate, times(1)).getForEntity(anyString(), eq(WeatherDTO.class));
    }

    @Test
    void testGetWeatherData_Failure() {
        String cityName = "InvalidCity";

        when(restTemplate.getForEntity(anyString(), eq(WeatherDTO.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            weatherService.getWeatherData(cityName);
        });

        verify(restTemplate, times(1)).getForEntity(anyString(), eq(WeatherDTO.class));
    }
}


