package com.dotin.course.services;

import com.dotin.course.entities.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class MessageServiceImpl implements MessageService{

    public final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldpu");


    @Override
    public Message save(Message message) {

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(message);

        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();

        entityManager.close();

        return message;
    }

    @Override
    public List<Message> getAll() {

        EntityManager entityManager = emf.createEntityManager();

        return entityManager.
                createQuery("select m from Message m").getResultList();
    }

    @Override
    public Optional<Message> getMessage(Long id) {
        return Optional.ofNullable(emf.createEntityManager().find(Message.class, id));
    }
}
