package br.com.thalleseduardo.cityweather.service;

import br.com.thalleseduardo.cityweather.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweather.api.baseurl}")
    private String baseUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    public WeatherDTO getWeatherData(String cityName) {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }
        ResponseEntity<WeatherDTO> resp =
                restTemplate.getForEntity(baseUrl + "/weather?q=" + cityName + "&appid=" + apiKey, WeatherDTO.class);
        return resp.getBody();
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
