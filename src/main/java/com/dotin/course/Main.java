package com.dotin.course;


import com.dotin.course.entities.Message;

public class Main {

    public static void main(String[] args) {

        Message message = new Message();
        message.setMessage("hello");


//        messages.stream().map(Message::getMessage).forEach(System.out::println);
    }
}
