package com.hieunv.test;

import java.util.ArrayList;

/**
 * Created by hieunv on 17/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> messages = new ArrayList<String>(){{
            add("I am a humand");
            add("I am not a humand");
            add("I am a cat");
            add("I am a dog");
        }};
        Message message = new Message(messages);
        message.getDuplicate(messages);
        System.out.println(message.getCentros(messages));
    }
}
