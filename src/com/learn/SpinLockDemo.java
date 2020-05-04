package com.learn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hulinqi
 * @date 2020/4/16 --  16:53
 * @purpuse
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference();

    //锁住
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" come in lock...");
        while (!atomicReference.compareAndSet(null,thread)){
            System.out.println(Thread.currentThread().getName()+"wating....");
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //解锁
    public void unLock(){
        Thread thread = Thread.currentThread();
        boolean b = atomicReference.compareAndSet(thread, null);
        //System.out.println("是否解锁成功了："+b+" / "+Thread.currentThread().getName()+" thread will been unlock..");

    }

    public static void main(String[] args){
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
            spinLockDemo.myLock();
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            spinLockDemo.unLock();
            System.out.println(Thread.currentThread().getName()+"  already unlock");
         }, "T1").start();

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockDemo.myLock();
            spinLockDemo.unLock();
            System.out.println(Thread.currentThread().getName()+"  already unlock");
        }, "T2").start();
    }
}
