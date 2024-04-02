package rtv.pl.rtvshop.search;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import rtv.pl.rtvshop.model.Item;
import rtv.pl.rtvshop.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final ItemRepository repository;
    private final EntityManager entityManager;

//    @Autowired
//    public SearchController(ItemRepository repository) {
//        this.repository = repository;
//    }

    @GetMapping
    public String search(@ModelAttribute SearchFormDto params, Model model) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
        Root<Item> root = criteriaQuery.from(Item.class);

        List<Predicate> predicates = new ArrayList<>();

        // Add conditions based on search parameters
        if (params.getName() != null && !params.getName().isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + params.getName() + "%"));
        }
        // Add more conditions for minPrice, maxPrice, brands, accessibility, etc.
        if (params.getMinPrice() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), params.getMinPrice()));
        }
        if (params.getMaxPrice() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), params.getMaxPrice()));
        }
        if (params.getBrands() != null && !params.getBrands().isEmpty()) {
            predicates.add(root.get("brand").in(params.getBrands()));
        }
        if (params.getAccessibility() != null && !params.getAccessibility().isEmpty()) {
            predicates.add(root.get("accessibility").in(params.getAccessibility()));
        }

        // Combine all predicates using AND
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        // Execute the query
        List<Item> items = entityManager.createQuery(criteriaQuery).getResultList();

        // You can add the retrieved items to the model if needed
        double minPrice = items.stream().mapToDouble(Item::getPrice).min().orElse(Double.MIN_VALUE);
        double maxPrice = items.stream().mapToDouble(Item::getPrice).max().orElse(Double.MAX_VALUE);
        model.addAttribute("searchText", params.getName());
        model.addAttribute("brands", items.stream().map(Item::getBrand).toList());
        model.addAttribute("foundItems", items);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        System.out.println(items);

        return "search";
    }
}