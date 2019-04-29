package lab1.services;

import lab1.model.Item;
import lab1.model.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    @EventListener(ContextRefreshedEvent.class)
    public void fillDB() {
        itemDao.save(Item.builder().name("Table").price(100).build());
        itemDao.save(Item.builder().name("Java").price(500).build());
        itemDao.save(Item.builder().name("Scala").price(300).build());
        itemDao.save(Item.builder().name("Kotlin").price(800).build());
        itemDao.save(Item.builder().name("Groovy").price(450).build());
        itemDao.save(Item.builder().name("Python").price(10).build());
    }

}


