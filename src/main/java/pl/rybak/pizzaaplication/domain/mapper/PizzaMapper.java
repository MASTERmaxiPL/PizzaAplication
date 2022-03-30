package pl.rybak.pizzaaplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.rybak.pizzaaplication.date.entity.pizza.PizzaEntity;
import pl.rybak.pizzaaplication.remote.rest.dto.request.AddPizzaDto;

@Component
public class PizzaMapper {

    public PizzaEntity mapToPizzaEntity(AddPizzaDto addPizzaDto){
        PizzaEntity pizzaEntity = new PizzaEntity();
        PizzaEntity.setName(addPizzaDto.getName());
        return pizzaEntity;
    }
}
