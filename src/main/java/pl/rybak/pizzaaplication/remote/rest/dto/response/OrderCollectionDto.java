package pl.rybak.pizzaaplication.remote.rest.dto.response;

import java.util.List;

public class OrderCollectionDto {
    private List<OrderDto> order;

    public OrderCollectionDto() {
    }

    public OrderCollectionDto(List<OrderDto> order) {
        this.order = order;
    }

    public List<OrderDto> getOrder() {
        return order;
    }
    public void setOrder(List<OrderDto> order) {
        this.order = order;
    }
}
