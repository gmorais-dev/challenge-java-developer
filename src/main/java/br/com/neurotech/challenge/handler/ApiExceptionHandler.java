package br.com.neurotech.challenge.handler;

import br.com.neurotech.challenge.Exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException e, HttpServletRequest request) {
        ApiErrorMessage resultMessange = new ApiErrorMessage();
        resultMessange.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultMessange);
    }
}

