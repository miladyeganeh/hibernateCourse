package com.dotin.course;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldpu");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Message message = new Message();
        message.setMessage("hello");

        entityManager.persist(message);

        entityManager.getTransaction().commit();

    }
}
