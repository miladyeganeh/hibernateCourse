package com.dotin.course.services;

import com.dotin.course.entities.Message;

import java.util.List;
import java.util.Optional;

import static com.dotin.course.util.EMF.runJpaCode;
import static com.dotin.course.util.EMF.runJpaCodeOpt;

public class MessageServiceImpl implements MessageService{

    @Override
    public Message save(Message message) {
        return runJpaCode(entityManager -> {
            entityManager.persist(message);
            return message;
        }, true);
    }

    @Override
    public List<Message> getAll() {
       return runJpaCode(entityManager -> entityManager.createQuery("SELECT m FROM Message m").getResultList());
    }

    @Override
    public Optional<Message> getMessage(Long id) {
        return  runJpaCodeOpt(entityManager -> entityManager.find(Message.class, id));
    }

    @Override
    public void delete(Message message) {
        runJpaCodeOpt(entityManager -> {
            entityManager.remove(message);
            return null;
        },true);
    }

    @Override
    public void deleteAll() {
        runJpaCode(entityManager -> entityManager
                .createQuery("DELETE FROM Message").executeUpdate(),true);
    }
}
