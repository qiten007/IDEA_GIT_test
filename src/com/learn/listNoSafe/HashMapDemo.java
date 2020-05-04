package com.learn.listNoSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hulinqi
 * @date 2020/4/16 --  14:20
 * @purpuse
 */
public class HashMapDemo {
    public static void main(String[] args){
        //List<String> list = Collections.synchronizedList(new ArrayList<String>());
        //Map map = new ConcurrentHashMap(); //HashMap
        Map map = Collections.synchronizedMap(new HashMap<>());
        //for(int i = 0; i < 3; i++ ){
        for(int i = 0; i < 30; i++ ){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 8));
                System.out.println("thread"+Thread.currentThread().getName()+"=====>>>"+map);
            }, String.valueOf(i)).start();
        }
    }
}


/*==========================HashMap的执行结果================================
thread1=====>>>{1=44eed21d}
Exception in thread "5" java.util.ConcurrentModificationException
thread3=====>>>{0=8f9fe24c, 1=44eed21d, 2=3bf5950b, 3=5f9e6538}
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1429)
thread0=====>>>{0=8f9fe24c, 1=44eed21d, 2=3bf5950b}
*
* */