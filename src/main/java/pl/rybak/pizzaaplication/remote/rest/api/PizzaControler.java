package pl.rybak.pizzaaplication.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rybak.pizzaaplication.domain.service.PizzaService;
import pl.rybak.pizzaaplication.remote.rest.dto.request.AddPizzaDto;
import pl.rybak.pizzaaplication.remote.rest.dto.request.UpdatePizzaDto;
import pl.rybak.pizzaaplication.remote.rest.dto.response.PizzaDto;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/pizzas/", produces = APPLICATION_JSON_VALUE)
@RestController
public class PizzaControler {
    private final PizzaService pizzaService;
    public PizzaControler(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }

 //   private final PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<PizzaDto> addPizza(@RequestBody AddPizzaDto addPizzaDto,
                                            @RequestHeader("Access-Token") String token){
        PizzaDto pizzaDto = pizzaService.addPizza(addPizzaDto, token);
        return ResponseEntity.ok(pizzaDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> updatePizza(@RequestBody UpdatePizzaDto updatePizzaDto,
                                                @RequestHeader("Access-Token") String token,
                                                @PathVariable("id")Integer pizzaId){
        return ResponseEntity.ok(null);
    }
    @DeleteMapping
    public ResponseEntity<Void> deletePizza(@PathVariable("id") Integer pizzaId,
                                            @RequestHeader("Access-Token") String token){
        return ResponseEntity.ok().build();
    }
}