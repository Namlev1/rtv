package rtv.pl.rtvshop.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rtv.pl.rtvshop.security.OrderService;

import java.security.Principal;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderService service;

    @GetMapping
    public String showOrders(Model model, Principal principal) {
//        model.addAttribute("orders", service.getOrders(principal.getName()));
        log.info("Showing orders for user: {}", principal.getName());
        return "order";
    }
}
