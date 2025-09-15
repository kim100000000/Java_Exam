package com.seongtae.level01.basic;

public class Circle extends Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return (radius * radius) * Math.PI; // 여기에 넓이를 넣어 줘야함
    }

    @Override
    double calculatePerimeter() {
        return (radius * 2) * Math.PI;
    }
}
