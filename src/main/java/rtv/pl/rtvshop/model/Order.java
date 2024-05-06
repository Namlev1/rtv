package rtv.pl.rtvshop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import rtv.pl.rtvshop.Cart;
import rtv.pl.rtvshop.security.User;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "order_")
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private final Cart cart;
    @ManyToOne
    private final User user;
    private final OrderStatus status;
    private final LocalDate date;
}
