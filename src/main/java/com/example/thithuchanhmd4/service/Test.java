package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.TestLombok;

public class Test{
    public static void main(String[] args) {
        TestLombok testLombok = new TestLombok();
        testLombok.setId(1L);
        testLombok.setName("Nguyen Van A");
        System.out.println(testLombok.getId());
        System.out.println(testLombok.getName());
    }
}
