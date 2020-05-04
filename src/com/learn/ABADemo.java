package com.learn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author hulinqi
 * @date 2020/4/16 --  0:14
 * @purpuse  介绍ABA问题，以及ABA的解决方案
 */
public class ABADemo {
    static AtomicReference<Integer> num1 = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> num2 = new AtomicStampedReference<>(100,1);
    public static void main(String[] args){
        System.out.println("==========================//以下是ABA问题的产生================================");
        

        new Thread(()->{
            num1.compareAndSet(100,101);
            num1.compareAndSet(101,100);
        }, "T1").start();

        new Thread(()->{
            try{ //保证T1的两次操作完成
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            boolean flag = num1.compareAndSet(100, 1024);
            System.out.println(" 是否执行成功："+flag + " ;当前的值是："+num1.get());
        }, "T2").start();

        
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("==========================//以下是ABA问题的解决================================");
        


        new Thread(()->{
            //假设T3操作两次
            int stamp = num2.getStamp();//获取初始版本号戳
            System.out.println("T3当前版本号："+stamp);
            try{ //等待一秒，让T4也获取到版本号和初始值
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("T3第一次获取的版本号和值是："+stamp+"-"+num2.getReference());
//            num2.compareAndSet(100,1024,stamp,stamp+1);
            num2.compareAndSet(100,1024,num2.getStamp(),num2.getStamp()+1);
            System.out.println("T3第二次获取的版本号和值是："+num2.getStamp()+"-"+num2.getReference());
            num2.compareAndSet(num2.getReference(), 108, num2.getStamp(), num2.getStamp() + 1);
            System.out.println("T3第三次获取的版本号和值是："+num2.getStamp()+"-"+num2.getReference());
            }, "T3").start();

        new Thread(()->{
            int stamp = num2.getStamp();//获取初始版本号戳
            System.out.println("T4当前版本号："+stamp);
            try{//保证t3执行完
                TimeUnit.SECONDS.sleep(3);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("T4在3秒后当前版本号："+num2.getStamp());
            boolean flag = num2.compareAndSet(108, 101, stamp, stamp + 1);
            System.out.println("T4是否执行成功："+flag);
            System.out.println("T4第二次获取的版本号和值是："+num2.getStamp()+"-"+num2.getReference());

         }, "T4").start();
    }
}

/*======================程序运行结果=======================
==========================//以下是ABA问题的产生================================
 是否执行成功：true ;当前的值是：1024
==========================//以下是ABA问题的解决================================
T3当前版本号：1
T4当前版本号：1
T3第一次获取的版本号和值是：1-100
T3第二次获取的版本号和值是：2-1024
T3第三次获取的版本号和值是：3-108
T4在3秒后当前版本号：3
T4是否执行成功：false
T4第二次获取的版本号和值是：3-108
*T4在三秒后获取当前的版本号已经实际变成3了，而之前的期望的还是最开始的1，所以导致无法进行CAS操作
*
* 注意：在多次操作的线程哪里，除第一次操作的期望值可以写死为初始值，后面CAS操作的期望值，都应该是getReference()通过方法获取当前值
* */
