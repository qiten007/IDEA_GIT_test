package com.mashibing.designModelForTank.strategy;

/**
 * @author hulinqi
 * @date 2020/5/4 --  17:05
 * @purpuse
 */
public interface StrategyComparator<T> {
    public int compare(T o1,T o2);
}
