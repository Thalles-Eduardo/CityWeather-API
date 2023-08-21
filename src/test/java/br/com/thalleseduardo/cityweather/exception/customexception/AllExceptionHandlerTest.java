package br.com.thalleseduardo.cityweather.exception.customexception;

import br.com.thalleseduardo.cityweather.exception.AllExceptionHandler;
import br.com.thalleseduardo.cityweather.exception.MessageExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllExceptionHandlerTest {

    @Test
    void testHandleNotFound() {
        AllExceptionHandler exceptionHandler = new AllExceptionHandler();
        NotFoundException exception = new NotFoundException("Resource not found");

        ResponseEntity<MessageExceptionHandler> response = exceptionHandler.handleNotFound(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Resource not found", Objects.requireNonNull(response.getBody()).getMessage());
    }
}
