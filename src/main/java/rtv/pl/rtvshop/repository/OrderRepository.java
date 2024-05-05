package rtv.pl.rtvshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rtv.pl.rtvshop.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
