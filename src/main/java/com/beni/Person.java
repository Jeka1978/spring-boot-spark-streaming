package com.beni;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Evgeny Borisov
 */
@Data
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private int age;
}
