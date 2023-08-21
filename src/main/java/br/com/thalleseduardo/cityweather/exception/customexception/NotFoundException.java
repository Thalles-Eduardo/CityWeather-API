package br.com.thalleseduardo.cityweather.exception.customexception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
