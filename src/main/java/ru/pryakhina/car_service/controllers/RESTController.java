package ru.pryakhina.car_service.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.pryakhina.car_service.dao.CarRepository;
import ru.pryakhina.car_service.entity.Body;
import ru.pryakhina.car_service.entity.Car;
import ru.pryakhina.car_service.entity.Weel;
import ru.pryakhina.car_service.service.СarServService;
import java.util.List;


/**
 * Класс контроллер
 * @author elena
 */
@Validated
@RestController
public class RESTController {

    /** */
    @Autowired
    private СarServService carServService;
    @Autowired
    private CarRepository carRepository;

    /** возвращает информацию обо всех существующих корпусах*/
    @GetMapping("/bodies")
    public List<Body> getAllCarBody(){
       return carServService.getAllBodyes();
    }

    /** возвращает информацию обо всех существующих колесах*/
    @GetMapping("/weels")
    public List<Weel> getAllCarWheels(){
        return carServService.getAllWeels();
    }

    /** Удаление корпуса*/
    @DeleteMapping("/bodies/{id}")
    public void deleteCarBody(@PathVariable int id){
        carServService.deleteBody(carServService.getBody(id));
    }

    /** Удаление колеса*/
    @DeleteMapping("/weels/{id}")
    public void deleteCarWeel(@PathVariable int id){
        carServService.deleteWeel(carServService.getWeel(id));
    }


    /** создает новую машину и сохраняет ее в БД*/
    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car){
        Car newCar = carServService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newCar);
    }


    /** возвращает полную информацию о существующем автомобиле
     * @param id*/
    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable int id){
        return carServService.getCar(id);
    }

    /** возвращает информацию обо всех существующих автомобилях с пагинацией*/
    @GetMapping("/cars")
    public Page<Car> getCars(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "5") @Min(1) @Max(50) Integer limit
    ){
        return carRepository.findAll(PageRequest.of(offset, limit));
    }
}