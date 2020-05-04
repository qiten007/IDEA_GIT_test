package com.learn;

/**
 * @author hulinqi
 * @date 2020/4/15 --  19:42
 * @purpuse
 */
public class Singleton {
    /*
    //1.懒汉式
    public static Singleton singleton = null;

    private Singleton(){
        System.out.println(Thread.currentThread().getName()+"   am congrate method!");
    }

    public static Singleton getSingleton(){ //加锁synchronization的话就是线程安全的懒汉式
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
    */

/*
    //饿汉式
    public static Singleton singleton = new Singleton();

    private Singleton(){
        System.out.println(Thread.currentThread().getName()+"   am congrate method!");
    }

    public static Singleton getSingleton(){
        return singleton;
    }
*/

//双检锁
    public static volatile Singleton singleton = null; //加volatile的原因是，在执行双锁的过程中间，在多线程环境下可能会发生指令重排，造成singleton对象名不副其实

    private Singleton(){
        System.out.println(Thread.currentThread().getName()+"   am congrate method!");
    }

    public static Singleton getSingleton(){
        if(singleton==null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args){
       for (int i = 0; i < 10; i++ ){
                 new Thread(()->{
                     Singleton.getSingleton();
                 }, String.valueOf(i)).start();
             }
//        System.out.println(Singleton.getSingleton() == Singleton.getSingleton());
//        System.out.println(Singleton.getSingleton() == Singleton.getSingleton());
//        System.out.println(Singleton.getSingleton() == Singleton.getSingleton());

    }

}
