package com.mashibing.designModelForTank.strategy;

/**
 * @author hulinqi
 * @date 2020/5/4 --  17:13
 * @purpuse
 */
public class StrategyDogFoodComparator implements StrategyComparator<Dog> {
    @Override
    public int compare(Dog d1, Dog d2) {
        if(d1.food < d2.food){
            return -1;
        }else if(d1.food > d2.food){
            return 1;
        }else{
            return 0;
        }
    }
}
