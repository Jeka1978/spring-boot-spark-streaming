package com.beni;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class MyDao {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void savePerson(Person person) {

        entityManager.persist(person);
        entityManager.detach(person);
        person.setAge(100);
        person.setAge(200);
        entityManager.merge(person);


    }
}
