package pl.rybak.pizzaaplication.domain.service;

import org.springframework.stereotype.Service;
import pl.rybak.pizzaaplication.date.entity.pizza.PizzaEntity;
import pl.rybak.pizzaaplication.date.entity.size.SizeEntity;
import pl.rybak.pizzaaplication.date.repository.PizzaRepository;
import pl.rybak.pizzaaplication.date.repository.SizeRepository;
import pl.rybak.pizzaaplication.domain.mapper.PizzaMapper;
import pl.rybak.pizzaaplication.domain.model.SizeType;
import pl.rybak.pizzaaplication.remote.rest.dto.request.AddPizzaDto;
import pl.rybak.pizzaaplication.remote.rest.dto.request.AddSizeDto;
import pl.rybak.pizzaaplication.remote.rest.dto.response.PizzaDto;
import pl.rybak.pizzaaplication.remote.rest.dto.response.SizeDto;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

import static pl.rybak.pizzaaplication.domain.service.UnauthorizationService.checkToken;

@Service
public class PizzaService {
    private final PizzaMapper pizzaMapper;
    private final PizzaRepository pizzaRepository;
    private final SizeRepository sizeRepository;
    private final SizeMapper sizeMapper;

    public PizzaService(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper, SizeRepository sizeRepository, SizeMapper sizeMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
        this.sizeRepository = sizeRepository;
        this.sizeMapper = sizeMapper;
    }

    public PizzaDto addPizza(AddPizzaDto addPizzaDto, String token){
        checkToken(token);
        //wpisujemy name pizzy do bazy danych
        pizzaRepository.save(pizzaMapper.mapToPizzaEntity(addPizzaDto));
        List<AddSizeDto> addSizeDtoList = addPizzaDto.getSizes();
        List<SizeEntity> sizeEntities = addSizeDtoList
        .stream()
        .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaEntity.getId()))
        .collect(Collectors.toList());
        sizeRepository.saveAll(sizeEntities);
        /*
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity .setSizeType(addSizeDto.getSize().name());
        sizeEntity .setPriceBase(addSizeDto.getPrice());
        sizeEntity.setId(addSizeDto.getId());
        sizeEntity.setPizzaId(saveIdPizzaEntity.getId());
        }).collect(Collectors.toList());
        PizzaEntity savedSizeEntity = SizeRepository.savAll(sizeEntities);
        */
        //mapowanie z encji do PizzaDto
        List<SizeDto> sizeDtoList = sizeEntities
                .stream()
                .map(SizeEntity -> sizeMapper.mapToSizeDto(sizeEntity))
                .collect(Collectors.toList());

        List<SizeDto> sizeDtoList = savedSizeEntities.stream()
                .map(sizeMapper::mapToSizeDto)
                .collect(Collectors.toList());
                 /*   SizeDto sizeDto = new SizeDto();
                    SizeDto.setSize(SizeType.valueOf(sizeEntity.getSizeType()));
                    SizeDto.setPrice(sizeEntity.getPriceBase());
                    SizeDto.setId(sizeEntity.getId());
                    return sizeDto;*/


       /* PizzaEntity pizzaEntity = new PizzaEntity();
        PizzaEntity.setName(addPizzaDto.getName());
        PizzaEntity savePizzaEntity = pizzaRepository.save(pizzaEntity);*/

    }
}