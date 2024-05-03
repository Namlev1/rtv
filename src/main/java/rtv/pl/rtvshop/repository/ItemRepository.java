package rtv.pl.rtvshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rtv.pl.rtvshop.model.Category;
import rtv.pl.rtvshop.model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findTop8ByAccessibilityIsTrue();

    List<Item> findByCategory(Category categories);

    @Query("SELECT i FROM Item i WHERE LOWER(i.name) LIKE LOWER(CONCAT('%',:name,'%'))")
    List<Item> findByNameContaining(@Param("name") String name);
}

