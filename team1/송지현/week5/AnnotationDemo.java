package com.example.demo;

public class AnnotationDemo {
}

class Parent{
    public void method(){
        System.out.print("parent");
    }
}
class Child extends Parent{
    @Override
    public void metod(){
        System.out.print("Child");
    }
}