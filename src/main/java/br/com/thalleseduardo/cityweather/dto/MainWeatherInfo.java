package br.com.thalleseduardo.cityweather.dto;

public class MainWeatherInfo {
    private double temp;
    private double temp_min;
    private double temp_max;


    public String getTemp() {
        return tempFormatted(temp);
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getTemp_min() {
        return tempFormatted(temp_min);
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return tempFormatted(temp_max);
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }



    public String tempFormatted(Double temp){
        double tempInCelsius = temp - 273.15;
        int roundedTemp = (int) Math.floor(tempInCelsius);

        double tempInFahrenheit = (tempInCelsius * 9/5) + 32;
        int roundedTempFahrenheit = (int) Math.floor(tempInFahrenheit);

        return String.format("%d°C or %d°F", roundedTemp, roundedTempFahrenheit);
    }
}
