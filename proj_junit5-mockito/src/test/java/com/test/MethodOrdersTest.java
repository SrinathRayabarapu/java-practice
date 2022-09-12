package com.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrdersTest {

    @Order(1)
    @Test
    void method3(){
        System.out.println("Executing method 3");
    }

    @Order(3)
    @Test
    void method1(){
        System.out.println("Executing method 1");
    }

    @Order(2)
    @Test
    void method4(){
        System.out.println("Executing method 4");
    }

    @Order(4)
    @Test
    void method2(){
        System.out.println("Executing method 2");
    }

}
