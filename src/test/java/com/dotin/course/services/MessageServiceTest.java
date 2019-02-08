package com.dotin.course.services;


import com.dotin.course.entities.Message;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class MessageServiceTest {

    private MessageService messageService = MessageService.GET();
    @Test
    public void success_persist_message(){
        Message message = new Message();
        message.setMessage("hello");

        assertThat(message.getId(), nullValue());

        Message saveMessage = messageService.save(message);

        assertThat(saveMessage.getId(), notNullValue());

        messageService.getMessage(saveMessage.getId()).map(m -> {
            assertThat(m.getMessage(), equalTo(message.getMessage()));
            return m;
        }).orElseGet(() ->{
            assertThat(false, equalTo(true ));
            return null;
        });
    }


}
