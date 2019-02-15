package com.dotin.course.services;

import com.dotin.course.entities.Item;

import java.util.List;

import static com.dotin.course.util.EMF.runJpaCode;

public class ItemServiceImpl implements ItemService {

    @Override
    public Item save(Item item) {
        return runJpaCode(entityManager -> {
            entityManager.persist(item);
            return item;
        }, true);
    }

    @Override
    public List<Item> getAll() {
        return runJpaCode(entityManager -> entityManager.createQuery("SELECT i FROM Item i").getResultList());
    }
}
