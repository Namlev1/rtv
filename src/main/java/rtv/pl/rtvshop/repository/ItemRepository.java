package rtv.pl.rtvshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rtv.pl.rtvshop.model.Category;
import rtv.pl.rtvshop.model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findTop8ByAccessibilityIsTrue();

    List<Item> findByNameContaining(String name);

    List<Item> findByCategory(Category categories);
}
