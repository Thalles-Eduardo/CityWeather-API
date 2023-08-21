package br.com.thalleseduardo.cityweather.exception.customexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotFoundExceptionTest {

    @Test
    void testNotFoundExceptionMessage(){
        String errorMessage = "Resource not found";
        NotFoundException notFoundException = new NotFoundException(errorMessage);

        assertEquals(errorMessage, notFoundException.getMessage());
    }
}
