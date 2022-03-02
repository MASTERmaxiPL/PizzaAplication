package pl.rybak.pizzaaplication.date.entity.ordersize;

import pl.rybak.pizzaaplication.date.entity.order.OrderEntity;
import pl.rybak.pizzaaplication.date.entity.pizza.PizzaEntity;
import pl.rybak.pizzaaplication.date.entity.size.SizeEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "order_sizes")
public class OrderSizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "size_id")
    private String sizeId;

    @Column(name = "size_count")
    private String sizeCount;

    @OneToMany
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private OrderEntity order;

    @OneToMany
    @JoinColumn(name = "size_id", insertable = false, updatable = false)
    private SizeEntity size;
}

