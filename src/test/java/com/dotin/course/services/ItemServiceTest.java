package com.dotin.course.services;

import com.dotin.course.entities.Bid;
import com.dotin.course.entities.Item;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ItemServiceTest {

    private ItemService itemService = ItemService.GET();
    private Item item;

    @Test
    public void success_persist_item(){

        Bid bid = new Bid();
        bid.setAmount(1000D);

        item = new Item();

//        item.getBids().add(bid);
        item.setBids(new HashSet<>(Arrays.asList(bid)));
        item.setImages(new HashSet<>(Arrays.asList("image1", "image2")));
        item.setTitle("test product");

        bid.setItem(item);

        Item savedItem = itemService.save(item);

        assertThat(savedItem.getId(), notNullValue());
    }


}
