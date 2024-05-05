package rtv.pl.rtvshop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import rtv.pl.rtvshop.Cart;
import rtv.pl.rtvshop.security.User;

@Data
@Entity
@Table(name = "order_")
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Cart cart;
    @OneToOne
    private User user;
    private OrderStatus status;
}
