package com.mashibing.designModelForTank.strategy;

/**
 * @author hulinqi
 * @date 2020/5/4 --  17:23
 * @purpuse
 */
public class StrategyCatComparatorByHeight implements StrategyComparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        if(c1.height < c2.height){
            return -1;
        }else if(c1.height > c2.height){
            return 1;
        }else{
            return 0;
        }
    }
}
