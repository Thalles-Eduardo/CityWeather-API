package br.com.thalleseduardo.cityweather.exception.customexception;

import br.com.thalleseduardo.cityweather.exception.MessageExceptionHandler;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageExceptionHandlerTest {

    @Test
    void testMessageExceptionHandler() {
        LocalDateTime timestamp = LocalDateTime.now();
        Integer status = 404;
        String message = "Resource not found";

        MessageExceptionHandler exceptionHandler = new MessageExceptionHandler(timestamp, status, message);

        assertEquals(timestamp, exceptionHandler.getTimestamp());
        assertEquals(status, exceptionHandler.getStatus());
        assertEquals(message, exceptionHandler.getMessage());
    }
}
