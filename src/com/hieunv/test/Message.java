package com.hieunv.test;

import java.util.*;

/**
 * Created by hieunv on 17/03/2017.
 */
public class Message {
    private ArrayList<String> messages;

    public Message(ArrayList<String> messages) {
        this.messages = messages;
    }

//    public double distance(String a, String b) {
//        Set<String> s1 = splitText(a);
//        Set<String> s2 = splitText(b);
//        int count = 0;
//        for (String i : s1) {
//            if (s2.contains(i)) count++;
//        }
//        return (double) count / (s1.size() + s2.size() - count);
//    }

    public Map<String, Integer> getDuplicate(ArrayList<String> lstItem) {
        Map<String, Integer> duplicate = new HashMap<>();
        for (String item : lstItem) {
            Set<String> s = splitText(item);
            for (String sItem : s) {
                if (duplicate.get(sItem) == null) duplicate.put(sItem, 1);
                else duplicate.put(sItem, duplicate.get(sItem) + 1);
            }
        }
        return duplicate;
    }

    public String getCentros(ArrayList<String> lstItem) {
        Map<String, Integer> duplicate = getDuplicate(lstItem);
        StringBuilder result = new StringBuilder();
        int count = 0;
        duplicate.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> {
                    if(count < 20){

                        result.append(k.getKey() + " ");
                    }
                    System.out.println(k.getKey() + " " +k.getValue());
                });

        return result.toString();
    }

    private Set<String> splitText(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.split("\\s+");
        for (String i : arr) set.add(i);
        return set;
    }
}
