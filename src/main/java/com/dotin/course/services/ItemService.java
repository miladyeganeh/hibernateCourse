package com.dotin.course.services;

import com.dotin.course.entities.Item;

import java.util.List;

public interface ItemService {

    Item save(Item item);
    List<Item> getAll();

    static ItemService GET(){
        return new ItemServiceImpl();
    }
}
