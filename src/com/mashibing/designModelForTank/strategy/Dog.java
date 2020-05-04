package com.mashibing.designModelForTank.strategy;

/**
 * @author hulinqi
 * @date 2020/5/4 --  17:12
 * @purpuse
 */
public class Dog {
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
