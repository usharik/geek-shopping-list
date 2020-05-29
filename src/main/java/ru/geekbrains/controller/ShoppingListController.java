package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.persist.ShoppingItem;
import ru.geekbrains.persist.ShoppingItemRepository;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import java.security.Principal;

@Controller
public class ShoppingListController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingListController.class);

    private final ShoppingItemRepository repository;

    private final UserRepository userRepository;

    @Autowired
    public ShoppingListController(ShoppingItemRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String indexPage(Model model, Principal principal) {
        logger.info("User name: {}", principal.getName());

        model.addAttribute("items", repository.findByUserUsername(principal.getName()));
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @PostMapping
    public String newShoppingItem(ShoppingItem item, Principal principal) {
        logger.info("User name: {}", principal.getName());

        User user = userRepository.findByUsername(principal.getName()).get();
        item.setUser(user);
        repository.save(item);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteShoppingItem(@PathVariable("id") long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
