package com.example.annotation2;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Person {
    private int    id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Person person) {
        return person.id == id;
    }

    public int hashCode() {
        return id;
    }

    public static void main(String[] args) {

//        Set<Person> set = new HashSet<Person>();
//        for (int i = 0; i < 10; i++) {
//            set.add(new Person(i, "Jim"));
//        }
//        System.out.println(set.size());
        showRunAnnotation();
    }

    private static void showRunAnnotation() {
        try {
            Class cls = Class.forName("com.example.annotation2.App");
            for (Method method :
                    cls.getMethods()) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                if(methodInfo != null) {
                    System.out.println("method name : "+method.getName());
                    System.out.println("method author : "+methodInfo.author());
                    System.out.println("method date : "+methodInfo.date());
                    System.out.println("method version : "+methodInfo.version());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
