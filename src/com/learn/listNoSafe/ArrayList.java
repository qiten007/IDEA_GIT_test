package com.learn.listNoSafe;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hulinqi
 * @date 2020/4/16 --  10:18
 * @purpuse
 */
public class ArrayList {
    public static void main(String[] args){
        //List<String> list = Collections.synchronizedList(new ArrayList<String>());
        List<String> list = new CopyOnWriteArrayList<String>();
        //for(int i = 0; i < 3; i++ ){
        for(int i = 0; i < 20; i++ ){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println("thread"+Thread.currentThread().getName()+"=====>>>"+list);
            }, String.valueOf(i)).start();
        }
    }
}
/*===================出现了如下结果================
[57e1df87, 40130460]
[57e1df87, 40130460]
[57e1df87, 40130460]
--------------------------------
[null, 2652a001]
[null, 2652a001]
[null, 2652a001]
----------------------------
[null, 38d7e63d, 5e6eeade]
[null, 38d7e63d, 5e6eeade]
[null, 38d7e63d, 5e6eeade]
---------------------------
[2a47857b]
[2a47857b, f66e498c]
[2a47857b, f66e498c, 0e0d4793]

所以可以说明arraylist是线程不安全的，而且当创建的线程稍微大一点（我这是5个线程的情况）的时候，会报错java.util.ConcurrentModificationException
Exception in thread "1" [6b243803]
[6b243803, null, bda38eea, 5e992249]
[6b243803, null, bda38eea, 5e992249, c4588abd]
[6b243803, e87d94b3, bda38eea, 5e992249, c4588abd]
java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at java.util.AbstractCollection.toString(AbstractCollection.java:461)
	at java.lang.String.valueOf(String.java:2994)
	at java.io.PrintStream.println(PrintStream.java:821)
	at com.learn.ArrayListDemo.lambda$main$0(ArrayListDemo.java:18)
	at java.lang.Thread.run(Thread.java:745)

//////////////////////////////错误现象的分析与解决////////////////////////////////
1.故障现象
      java.util.ConcurrentModificationException
2.导致原因
       ArrayList在多个线程下添加数组出现的bug
3.解决方案
        1.Vector,加了锁，线程安全，但是并发性就不高，不推荐使用
        2.Collections.synchronizedList(new ArrayList<String>()) --把线程不安全的在外面封装成一个线程安全的
        3.new CopyOnWriteArrayList<String>();
4.优化建议（避免发生同样的问题）
* */

/*
写时复制的核心代码：在添加一个元素时，先复制原有的List，然后在原有的List上增添一个元素从而得到新的List，然后将原有的引用修改到新的List上，原来的List作废，
                 这样的好处是可以并发的读写而不需要加锁，实现了读写分离。
* public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }
* */