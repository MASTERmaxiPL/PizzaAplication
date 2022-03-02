package pl.rybak.pizzaaplication.date.entity.size;

import pl.rybak.pizzaaplication.date.entity.ordersize.OrderSizeEntity;
import pl.rybak.pizzaaplication.date.entity.pizza.PizzaEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "sizes")
public class SizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "size_type")
    private String sizeType;

    @Column(name = "price_base")
    private BigDecimal priceBase;

    @Column(name = "pizza_id")
    private Integer pizzaId;

    @OneToMany(mappedBy = "size")
    private Set<OrderSizeEntity> orderSizes;

    @OneToMany(mappedBy = "pizza_id", insertable = false, updatable = false)
    private PizzaEntity pizza;
}