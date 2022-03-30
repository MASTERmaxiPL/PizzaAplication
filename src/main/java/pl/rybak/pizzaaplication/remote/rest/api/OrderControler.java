package pl.rybak.pizzaaplication.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rybak.pizzaaplication.domain.model.OrderStatusType;
import pl.rybak.pizzaaplication.remote.rest.dto.request.AddOrderDto;
import pl.rybak.pizzaaplication.remote.rest.dto.request.UpdateOrderDto;
import pl.rybak.pizzaaplication.remote.rest.dto.response.OrderCollectionDto;
import pl.rybak.pizzaaplication.remote.rest.dto.response.OrderDto;
import pl.rybak.pizzaaplication.remote.rest.dto.response.OrderStatusDto;
import pl.rybak.pizzaaplication.remote.rest.dto.response.TokenDto;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/orders/", produces = APPLICATION_JSON_VALUE)
@RestController
public class OrderControler {



    @PostMapping
    public ResponseEntity<TokenDto> addOrder(@RequestBody AddOrderDto addOrderDto){

        return ResponseEntity.ok(null);
    }
    @GetMapping("/status/{token}")
    public ResponseEntity<OrderStatusDto> getStatus(@PathVariable("token")String token){
        return ResponseEntity.ok(null);

    }
    @GetMapping
    public ResponseEntity<OrderCollectionDto> getOrders(@RequestParam("status")OrderStatusType orderStatusType,
                                                        @RequestHeader("Access-Token")String token){

        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/{order-id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("order-id") Integer orderId,
                                            @RequestHeader("Access-Token") String token){
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{order-id}")
    public ResponseEntity<OrderDto> upgradeOrder(@RequestHeader("Access-Token")String token,
                                                 @PathVariable("order-id") Integer orderId,
                                                 @RequestBody UpdateOrderDto updateOrderDto){
        OrderDto orderDto = updateOrderDto
        return ResponseEntity.ok(null);
    }

}
