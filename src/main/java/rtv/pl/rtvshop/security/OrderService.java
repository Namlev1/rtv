package rtv.pl.rtvshop.security;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rtv.pl.rtvshop.Cart;
import rtv.pl.rtvshop.model.Order;
import rtv.pl.rtvshop.model.OrderStatus;
import rtv.pl.rtvshop.repository.OrderRepository;
import rtv.pl.rtvshop.repository.UserRepository;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    @PersistenceContext
    private final EntityManager entityManager;

    public List<Order> getOrders(String username) {
        User user = userRepository.findByUsername(username);
        return orderRepository.findByUser(user);
    }

    @Transactional
    public Order saveOrder(Principal principal, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("scopedTarget.cart");
        User user = userRepository.findByUsername(principal.getName());
        Order order = new Order(cart, user, OrderStatus.NEW, LocalDate.now());
        order = orderRepository.save(order);
        Cart newCart = new Cart();
        session.setAttribute("scopedTarget.cart", newCart);
        return order;
    }
}
