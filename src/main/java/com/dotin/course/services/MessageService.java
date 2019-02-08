package com.dotin.course.services;

import com.dotin.course.entities.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    Message save(Message message);
    List<Message> getAll();
    Optional<Message> getMessage(Long id);
    void delete(Message message);
    void deleteAll();

    static MessageService GET(){
        return new MessageServiceImpl();
    }

}
