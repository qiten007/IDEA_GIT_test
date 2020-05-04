package com.mashibing.designModelForTank.factory;

/**
 * @author hulinqi
 * @date 2020/5/4 --  22:27
 * @purpuse
 */
//简单工厂的可扩展性不好
public class SimpleVihicleFactory {
    public Car createCar(){
        return new Car();
    }

    public Plan createPlan(){
        return new Plan();
    }
}
