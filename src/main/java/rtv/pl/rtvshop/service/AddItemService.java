package rtv.pl.rtvshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rtv.pl.rtvshop.model.AddItemForm;
import rtv.pl.rtvshop.model.Item;
import rtv.pl.rtvshop.repository.ItemRepository;

@Service
@RequiredArgsConstructor
public class AddItemService {
    private final ItemRepository repository;

    public Item saveItem(AddItemForm form){
        Item item = form.toItem();
        return repository.save(item);
    }
}
