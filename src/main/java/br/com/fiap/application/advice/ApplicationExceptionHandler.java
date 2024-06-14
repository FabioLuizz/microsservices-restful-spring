package br.com.fiap.application.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> HandleInvalidArguments(MethodArgumentNotValidException error) {
        Map<String, String> mapError = new HashMap<>();
        List<FieldError> fields = error.getBindingResult().getFieldErrors();

        for(FieldError field: fields) {
            mapError.put(field.getField(), field.getDefaultMessage());
        }

        return mapError;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleDataIntegrity() {
        Map<String, String> mapError = new HashMap<>();
        mapError.put("Error", "Already registered user");

        return mapError;
    }

}
