package com.learn;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hulinqi
 * @date 2020/4/15 --  21:38
 * @purpuse
 */
public class CompareAndSet {
    public static void main(String[] args){
        AtomicInteger num = new AtomicInteger(5);

        System.out.println(num.compareAndSet(5,2020) + " === and current num is : "+ num.get());

        System.out.println(num.compareAndSet(5,0415) + " === and current num is : "+ num.get());

        num.getAndIncrement();
    }
}
