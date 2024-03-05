package rtv.pl.rtvshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import rtv.pl.rtvshop.model.Item;
import rtv.pl.rtvshop.repository.ItemRepository;

import java.util.List;

@Configuration
public class DBInit implements CommandLineRunner {
    private final ItemRepository repository;

    @Autowired
    public DBInit(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Item> items = List.of(
                new Item("Telewizor LG", 399, 4.5, "a"),
                new Item("Telewizor Samsung", 499, 4.3, "b"),
                new Item("Laptop HP", 1499, 3.9, "c"),
                new Item("Lodówka LG", 800, 5.0, "d"),
                new Item("Toster", 800, 2.3, "e"),
                new Item("Iphone 15", 3800, 5.0, "f")
        );
        repository.saveAll(items);
    }
}
