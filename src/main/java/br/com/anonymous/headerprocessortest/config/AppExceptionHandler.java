package br.com.anonymous.headerprocessortest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<Object> handleGenericException(Exception ex) {
        log.error("Erro durante a execução da requisição: {}", ex.getMessage(), ex);
        return ResponseEntity.internalServerError().body(Map.of("message", ex.getMessage()));
    }

}
