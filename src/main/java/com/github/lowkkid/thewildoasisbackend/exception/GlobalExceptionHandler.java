package com.github.lowkkid.thewildoasisbackend.exception;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    private static final String ARGUMENT_VALIDATION_FAILED = "Argument validation failed.";


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotFoundException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<String> handle(MethodArgumentNotValidException ex) {
        log.error("Method arguments are not valid", ex);
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ARGUMENT_VALIDATION_FAILED + " " + allErrors.get(0).getDefaultMessage());
    }

}

