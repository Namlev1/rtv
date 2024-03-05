package rtv.pl.rtvshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rtv.pl.rtvshop.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
