package com.dotin.course.services;


import com.dotin.course.entities.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAnd;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;


public class MessageServiceTest {

    private MessageService messageService = MessageService.GET();

    private Message message1;
    private Message message2;

    @Before
    public void init(){

        message2 = new Message();
        message2.setMessage("message2");

        messageService.save(message2);
    }

    @After
    public void clean(){
        messageService.deleteAll();
    }

    @Test
    public void success_persist_message(){
        message1 = new Message();
        message1.setMessage("hello");

        assertThat(message1.getId(), nullValue());

        Message saveMessage = messageService.save(message1);

        assertThat(saveMessage.getId(), notNullValue());

        assertThat(messageService.getMessage(saveMessage.getId()),
                isPresentAnd(samePropertyValuesAs(message1)));
    }

    @Test
    public void success_get_all_messages(){
        Message message3 = new Message();
        message3.setMessage("message3");

        Message saveMessage = messageService.save(message3);

        List<Message> list = messageService.getAll();

        assertThat(list.size(), equalTo(2));

        List<String>listName = new ArrayList<>();

        for (Message message : list) {
            listName.add(message.getMessage());
        }

        assertThat(listName, containsInAnyOrder("message3", "message2"));
    }
}
