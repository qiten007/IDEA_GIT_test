package com.mashibing.designModelForTank.strategy;

import java.util.Comparator;

/**
 * @author hulinqi
 * @date 2020/5/4 --  17:00
 * @purpuse
 */
public class StrategySorter<T> {
    public void sort(T[] arr, StrategyComparator<T> comparator){
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j],arr[minPos])== -1 ? j : minPos;
            }

            swop(arr, i, minPos);
        }
    }

    private void swop(T[] arr, int i, int j) {
        T tep = arr[i];
        arr[i] = arr[j];
        arr[j] = tep;
    }
}
