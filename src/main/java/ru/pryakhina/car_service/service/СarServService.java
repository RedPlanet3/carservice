package ru.pryakhina.car_service.service;


import ru.pryakhina.car_service.entity.Body;
import ru.pryakhina.car_service.entity.Car;
import ru.pryakhina.car_service.entity.Weel;


import java.util.List;

/**
 * Интерфейс Service
 * @author elena
 */
public interface СarServService {
    public List<Body> getAllBodyes();
    public List<Weel> getAllWeels();
    public List<Car> getAllCars();
    public Body saveBody(Body body);
    public Weel saveWeel(Weel weel);
    public Car saveCar(Car car);

    void deleteBody(Body body);
    void deleteWeel(Weel weel);
    void deleteCar(Car car);

    public Body getBody(int bodyId);
    public Weel getWeel(int weelId);
    public Car getCar(int carId);

}
