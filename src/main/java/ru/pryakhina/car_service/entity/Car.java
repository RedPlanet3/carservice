package ru.pryakhina.car_service.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Класс авто
 * @author elena
 */

@Entity
@Table(name = "cars")
public class Car {
    /** Поле ID авто*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** Поле имя авто*/
    @NotBlank
    @Column(name = "name")
    private String name;

    /** Поле ссылка на корпус, который используется в текущей машине */
    @NotNull
    @Valid
    @ManyToOne
    @JoinColumn(name = "body_id")
    private Body body;

    /** Поле ссылка на тип колеса, который используется в текущей машине */
    @NotNull
    @Valid
    @ManyToOne
    @JoinColumn(name = "weel_id")
    private Weel weel;

    /** Количество колес в авто */
    @Min(2)
    @Column(name = "num_of_weel")
    private int numOfWeel;

    /** Конструктор авто */
    public Car() {
    }

    /** Конструктор авто */
    public Car(String name, Body body, Weel weel, int numOfWeel) {
        this.name = name;
        this.body = body;
        this.weel = weel;
        this.numOfWeel = numOfWeel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Weel getWeel() {
        return weel;
    }

    public void setWeel(Weel weel) {
        this.weel = weel;
    }

    public int getNumOfWeel() {
        return numOfWeel;
    }

    public void setNumOfWeel(int numOfWeel) {
        this.numOfWeel = numOfWeel;
    }
}
