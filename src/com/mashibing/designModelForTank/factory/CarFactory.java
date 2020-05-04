package com.mashibing.designModelForTank.factory;

/**
 * @author hulinqi
 * @date 2020/5/4 --  22:30
 * @purpuse
 */
public class CarFactory {
    public Car create(){
        System.out.println("the car will be create");
        return new Car();
    }
}
