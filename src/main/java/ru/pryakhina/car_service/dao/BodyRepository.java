package ru.pryakhina.car_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pryakhina.car_service.entity.Body;

import java.util.Optional;


/**
 * Интерфейс bodies
 * @author elena
 */
public interface BodyRepository extends JpaRepository<Body, Integer> {
    Optional<Body> findByName(String name);
}