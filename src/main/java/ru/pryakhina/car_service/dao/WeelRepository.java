package ru.pryakhina.car_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pryakhina.car_service.entity.Body;
import ru.pryakhina.car_service.entity.Weel;

import java.util.Optional;


/**
 * Интерфейс weels
 * @author elena
 */
public interface WeelRepository extends JpaRepository<Weel, Integer> {
    Optional<Weel> findByName(String name);
}