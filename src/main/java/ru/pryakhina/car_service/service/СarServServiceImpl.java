package ru.pryakhina.car_service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pryakhina.car_service.dao.BodyRepository;
import ru.pryakhina.car_service.dao.CarRepository;
import ru.pryakhina.car_service.dao.WeelRepository;
import ru.pryakhina.car_service.entity.Body;
import ru.pryakhina.car_service.entity.Car;
import ru.pryakhina.car_service.entity.Weel;
import ru.pryakhina.car_service.exception_handing.NotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Реализация интерфейса Service
 * @author elena
 */
@Service
public class СarServServiceImpl implements СarServService {

    @Autowired
    BodyRepository bodyRepository;
    @Autowired
    WeelRepository weelRepository;
    @Autowired
    CarRepository carRepository;

    /**
     * @return
     */
    @Override
    public List<Body> getAllBodyes() {
        return bodyRepository.findAll();
    }

    /**
     * @return
     */
    @Override
    public List<Weel> getAllWeels() {
        return weelRepository.findAll();
    }

    /**
     * @return
     */
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    /**
     * @param body
     * @return
     */
    @Override
    public Body saveBody(Body body) {
        return bodyRepository.save(body);
    }

    /**
     * @param weel
     * @return
     */
    @Override
    public Weel saveWeel(Weel weel) {
        return weelRepository.save(weel);
    }

    /**
     * @param car
     * @return
     */
    @Override
    public Car saveCar(Car car) {
        car.setBody(getBody(car.getBody()));
        car.setWeel(getWeel(car.getWeel()));
        return carRepository.save(car);
    }

    private Body getBody(Body body) {
        if (body.getId() == null) {
            return bodyRepository.findByName(body.getName())
                    .orElseGet(() -> bodyRepository.save(body));
        }
        return bodyRepository.findById(body.getId())
                .orElseThrow(() -> new NotFoundException("body with id " + body.getId() + " not found"));
    }

    private Weel getWeel(Weel weel) {
        if (weel.getId() == null) {
            return weelRepository.findByName(weel.getName())
                    .orElseGet(() -> weelRepository.save(weel));
        }
        return weelRepository.findById(weel.getId())
                .orElseThrow(() -> new NotFoundException("weel with id " + weel.getId() + " not found"));
    }


    /**
     * @param body
     */
    @Override
    public void deleteBody(Body body) {
        bodyRepository.delete(body);
    }

    /**
     * @param weel
     */
    @Override
    public void deleteWeel(Weel weel) {
        weelRepository.delete(weel);
    }

    /**
     * @param car
     */
    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    /**
     * @param bodyId
     * @return
     */
    @Override
    public Body getBody(int bodyId) {
        Optional<Body> body = bodyRepository.findById(bodyId);
        return body.orElse(null);
    }

    /**
     * @param weelId
     * @return
     */
    @Override
    public Weel getWeel(int weelId) {
        Optional<Weel> optional = weelRepository.findById(weelId);
        return optional.orElse(null);
    }

    /**
     * @param carId
     * @return
     */
    @Override
    public Car getCar(int carId) {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.orElse(null);
    }
}
