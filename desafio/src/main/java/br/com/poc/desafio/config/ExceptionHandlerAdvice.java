package br.com.poc.desafio.config;

import br.com.poc.desafio.exceptions.InvalidJsonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidJsonException.class)
    public ResponseEntity getInvalidExceptionHandler(InvalidJsonException ex){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity getIOExceptionHandler(IOException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao escrever ou buscar o arquivo no disco do sistema.");
    }

}
