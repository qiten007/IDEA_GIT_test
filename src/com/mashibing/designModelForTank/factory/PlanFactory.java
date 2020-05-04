package com.mashibing.designModelForTank.factory;

/**
 * @author hulinqi
 * @date 2020/5/4 --  22:31
 * @purpuse
 */
public class PlanFactory {
    public Plan create(){
        System.out.println("the plan will be create ");
        return new Plan();
    }
}
