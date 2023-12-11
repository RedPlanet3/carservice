package ru.pryakhina.car_service.exception_handing;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
