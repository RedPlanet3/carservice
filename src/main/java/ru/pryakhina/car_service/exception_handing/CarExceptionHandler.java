package ru.pryakhina.car_service.exception_handing;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class CarExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(NotFoundException exception){
        IncorrectData data = new IncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(Exception exception){
        IncorrectData data = new IncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(MethodArgumentNotValidException exception){
        Object[] args = exception.getDetailMessageArguments();
        String message = Arrays.stream(args).map(s -> (String) s)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(", "));
        IncorrectData data = new IncorrectData(message);
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
