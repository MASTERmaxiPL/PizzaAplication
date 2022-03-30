package pl.rybak.pizzaaplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.rybak.pizzaaplication.date.entity.size.SizeEntity;
import pl.rybak.pizzaaplication.domain.model.SizeType;
import pl.rybak.pizzaaplication.remote.rest.dto.request.AddSizeDto;
import pl.rybak.pizzaaplication.remote.rest.dto.response.SizeDto;

@Component
public class SizeMapper {
    public SizeEntity mapToSizeEntity(AddSizeDto addSizeDto, Integer pizzaId){
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity .setSizeType(addSizeDto.getSize().name());
        sizeEntity .setPriceBase(addSizeDto.getPrice());
        sizeEntity.setPizzaId(pizzaId);
        return sizeEntity;
    }
    public SizeDto mapToSizeDto(SizeEntity sizeEntity){
        SizeDto sizeDto = new SizeDto();
        SizeDto.setSize(SizeType.valueOf(sizeEntity.getSizeType()));
        SizeDto.setPrice(sizeEntity.getPriceBase());
        SizeDto.setId(sizeEntity.getId());
        return sizeDto;
    }
}
