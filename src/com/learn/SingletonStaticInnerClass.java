package com.learn;

/**
 * @author hulinqi
 * @date 2020/4/15 --  20:35
 * @purpuse
 */
public  class  SingletonStaticInnerClass {

    private SingletonStaticInnerClass(){
        //DoNothing
    }

    private static class innerHolder{
        private static  SingletonStaticInnerClass mySingleton = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getSingleton(){
        return innerHolder.mySingleton;
    }
}
