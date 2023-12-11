package ru.pryakhina.car_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pryakhina.car_service.entity.Car;

/**
 * Интерфейс cars
 * @author elena
 */
public interface CarRepository extends JpaRepository<Car, Integer> {
}