package lab1.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface ItemDao extends JpaRepository<Item,Integer> {
    List<Item> findByPriceGreaterThan(int price);
}
