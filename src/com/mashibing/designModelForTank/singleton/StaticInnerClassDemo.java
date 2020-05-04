package com.mashibing.designModelForTank.singleton;

/**
 * @author hulinqi
 * @date 2020/4/23 --  17:28
 * @purpuse
 */
public class StaticInnerClassDemo {
    private StaticInnerClassDemo(){}

    private static class InnerClassHolder{
        private  final static StaticInnerClassDemo INSTANCE = new StaticInnerClassDemo();
    }

    public static StaticInnerClassDemo getInstance(){
        return InnerClassHolder.INSTANCE;
    }
}
