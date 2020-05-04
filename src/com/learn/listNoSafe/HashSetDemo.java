package com.learn.listNoSafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hulinqi
 * @date 2020/4/16 --  11:34
 * @purpuse
 */
public class HashSetDemo {
    public static void main(String[] args){
        Set hashSet = new HashSet();
        //for(int i = 0; i < 3; i++ ){
        for(int i = 0; i < 20; i++ ){
            new Thread(()->{
                hashSet.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println("thread"+Thread.currentThread().getName()+"=====>>>"+hashSet);
            }, String.valueOf(i)).start();
        }
    }
}
