package ru.pryakhina.car_service.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

/**
 * Класс корпус
 * @author elena
 */
@Entity
@Table(name = "bodies")
public class Body {

        /** Поле ID корпуса */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        /** Поле имя корпуса */
        @NotBlank
        @Column(name = "name")
        private String name;

        /** Поле ссылка на авто, которые используют этот корпус */
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "body")
        private List<Car> cars;

        /** Конструктор корпуса */
        public Body(String name) {
                this.name = name;
        }

        /** Конструктор корпуса */
        public Body() {
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
