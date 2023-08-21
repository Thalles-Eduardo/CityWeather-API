package br.com.thalleseduardo.cityweather.exception;

import br.com.thalleseduardo.cityweather.exception.customexception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> handleNotFound(NotFoundException exception){
        MessageExceptionHandler error = new MessageExceptionHandler(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
