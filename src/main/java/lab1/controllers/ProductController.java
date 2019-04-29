package lab1.controllers;

import lab1.model.Item;
import lab1.model.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@RestController
public class ProductController {
    @Autowired
    private ItemDao itemDao;




    @GetMapping("/item/find")
    public List<Item> getItemAbovePrice(@RequestParam("price") Integer price) {
        return itemDao.findByPriceGreaterThan(price);
    }
    @GetMapping("/item/all")
    public List<Item> getAllItems() {
        return itemDao.findAll();
    }
}



