package br.com.thalleseduardo.cityweather;

import br.com.thalleseduardo.cityweather.dto.MainWeatherInfo;
import br.com.thalleseduardo.cityweather.dto.WeatherDTO;
import br.com.thalleseduardo.cityweather.dto.WeatherInfo;
import br.com.thalleseduardo.cityweather.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class WeatherControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WeatherService weatherService;

	@Test
	void testGetWeather_ValidCity_ReturnsWeatherData() throws Exception {
		WeatherDTO mockWeatherDTO = new WeatherDTO();
		mockWeatherDTO.setName("CityName");
		MainWeatherInfo mainWeatherInfo = new MainWeatherInfo();
		mainWeatherInfo.setTemp(300);
		mainWeatherInfo.setTemp_max(310.0);
		mainWeatherInfo.setTemp_min(290.0);
		mockWeatherDTO.setMain(mainWeatherInfo);
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setDescription("Sunny");
		mockWeatherDTO.setWeather(Collections.singletonList(weatherInfo));

		when(weatherService.getWeatherData(anyString())).thenReturn(mockWeatherDTO);

		mockMvc.perform(get("/weather/CityName"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json("{" +
						"\"City name\":\"CityName\"," +
						"\"Description\":\"Sunny\"," +
						"\"Temperature\":\"26°C or 80°F\"," +
						"\"Max. temperature\":\"36°C or 98°F\"," +
						"\"Min. temperature\":\"16°C or 62°F\"" +
						"}"));
	}
}

