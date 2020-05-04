package com.mashibing.designModelForTank.singleton;

/**
 * @author hulinqi
 * @date 2020/4/23 --  16:03
 * @purpuse
 */
public class HungryDemo {
    private static final HungryDemo INSTANCE = new HungryDemo();

    private HungryDemo(){}

    public static HungryDemo getInstance(){
        return INSTANCE;
    }
}
