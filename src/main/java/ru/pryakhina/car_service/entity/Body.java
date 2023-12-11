package ru.pryakhina.car_service.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

/**
 * Класс
 * @author elena
 */
@Entity
@Table(name = "bodies")
public class Body {

        /** Поле ID продукта */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        /** Поле имя продукта */

        @NotBlank
        @Column(name = "name")
        private String name;

        /** Поле ссылка на роль, к которой относится текущий продукт */
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "body")
        private List<Car> cars;

        public Body(String name) {
                this.name = name;
        }

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

//        public List<Car> getCars() {
//                return cars;
//        }
//
//        public void setCars(List<Car> cars) {
//                this.cars = cars;
//        }
}
