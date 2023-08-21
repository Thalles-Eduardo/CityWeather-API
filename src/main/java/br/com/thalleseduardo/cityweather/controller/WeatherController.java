package br.com.thalleseduardo.cityweather.controller;

import br.com.thalleseduardo.cityweather.dto.WeatherDTO;
import br.com.thalleseduardo.cityweather.exception.customexception.NotFoundException;
import br.com.thalleseduardo.cityweather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/{cityName}")
    public Map<String, Object> getWeather(@PathVariable("cityName") String cityName) {
        try {
            WeatherDTO weatherDTO = weatherService.getWeatherData(cityName);

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("City name", weatherDTO.getName());
            response.put("Description", weatherDTO.getWeather().get(0).getDescription());
            response.put("Temperature", weatherDTO.getMain().getTemp());
            response.put("Max. temperature", weatherDTO.getMain().getTemp_max());
            response.put("Min. temperature", weatherDTO.getMain().getTemp_min());

            return  response;
        }catch (RuntimeException e) {
            throw new NotFoundException("Cidade inválida!");
        }

    }
}
