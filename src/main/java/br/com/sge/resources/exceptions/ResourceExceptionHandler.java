package br.com.sge.resources.exceptions;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException; // Importe a classe correta
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.sge.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandartError error = new StandartError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Recurso não encontrado");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class) // Use DataIntegrityViolationException
    public ResponseEntity<StandartError> dataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
        StandartError error = new StandartError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Erro de Integridade de Dados");
        error.setMessage("Não é possível excluir o recurso, pois está sendo usado em outra parte do sistema.");
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
