package com.learn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hulinqi
 * @date 2020/4/16 --  16:01
 * @purpuse
 */
//介绍递归锁
class Phone implements  Runnable{
    public synchronized void sendEms(){
        System.out.println(Thread.currentThread().getName()+" 开始发EMS");
        sendEmail();
    }

    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+" 开始发Email");
    }


    //===============这边介绍ReenTrantLock递归锁==============
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" invoke get()");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" ####invoke set()");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

public class ReenTrantLockdemo {
    public static void main(String[] args){
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendEms();
         }, "t1").start();

        new Thread(()->{
            phone.sendEms();
        }, "t2").start();


        try{ //让上面先执行
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();

    }

}
/*===================执行结果==================
t1 开始发Email
t2 开始发EMS
t2 开始发Email
*
* */