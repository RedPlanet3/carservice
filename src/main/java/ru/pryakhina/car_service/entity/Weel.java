package ru.pryakhina.car_service.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

/**
 * Класс колесо
 * @author elena
 */

@Entity
@Table(name = "weels")
public class Weel {

    /** Поле ID колеса */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** Поле имя колеса */
    @NotBlank
    @Column(name = "name")
    private String name;

    /** Поле ссылка на авто, которые используют этот тип колеса */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weel")
    private List<Car> cars;


    /**
     * Конструктор - создание нового колеса с определенными значениями
     * @param name - имя роли
     */
    public Weel(String name) {
        this.name = name;
    }

    /**
     * Конструктор - создание нового колеса
     */
    public Weel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}