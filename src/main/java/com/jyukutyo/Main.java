package com.jyukutyo;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello World!");
        System.out.println(new Main().toString());
    }

    @Override
    public String toString() {
        return "toString() is called.";
    }
}
