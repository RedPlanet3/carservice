package ru.pryakhina.car_service.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

/**
 *
 * @author elena
 */

@Entity
@Table(name = "weels")
public class Weel {

    /** Поле ID роли */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** Поле имя роли */
    @NotBlank
    @Column(name = "name")
    private String name;

    /** Поле ссылка на продукты,
     * относящиеся к текущей роли */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weel")
    private List<Car> cars;


//    /**
//     * Функция получения значения поля {@link List< Body >#bodies}
//     * @return List<Body>
//     */
//    public List<Body> getItems() {
//        return bodies;
//    }
//
//    /**
//     * Процедура добавления продукта в список продуктов
//     * текущей роли {@link List< Body >#bodies}
//     * @param body
//     */
//    public void addItemToRole(Body body){
//        if (this.bodies == null)
//            this.bodies = new ArrayList<>();
//        this.bodies.add(body);
//        body.setRole(this);
//    }

//    /**
//     * Процедура установления списка продуктов для
//     * текущей роли {@link List< Body >#bodies}
//     * @param bodies
//     */
//    public void setItems(List<Body> bodies) {
//        this.bodies = bodies;
//    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param name - имя роли
     */
    public Weel(String name) {
        this.name = name;
    }

    /**
     * Конструктор - создание нового объекта роли
     */
    public Weel() {
    }

    /**
     * Функция получения значения поля id {@link Weel#id}
     * @return возвращает id продукта
     */
    public Integer getId() {
        return id;
    }

    /**
     * Процедура заполнения поля id {@link Weel#id}
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Функция получения значения поля name {@link Weel#name}
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура заполнения поля name {@link Weel#name}
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}