package pl.rybak.pizzaaplication.date.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rybak.pizzaaplication.date.entity.pizza.PizzaEntity;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {

}
