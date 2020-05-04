package com.mashibing.designModelForTank.strategy;
import java.util.Arrays;

/**
 * @author hulinqi
 * @date 2020/5/4 --  14:32
 * @purpuse
 */
public class Main {
    public static void main(String[] args){
/*
        int[] a = {9,2,3,5,7,5,2,6,8};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));

        Cat[] cats = {new Cat(1,1),new Cat(3,3),new Cat(5,5)};
        sorter.sort(cats);
        System.out.println(Arrays.toString(cats));
*/

        //======================Strategy========================
        Dog[] dogs = {new Dog(1),new Dog(5),new Dog(3)};
        StrategySorter<Dog> dogStrategySorter = new StrategySorter<Dog>();
        dogStrategySorter.sort(dogs,new StrategyDogFoodComparator());
        System.out.println("狗按照食量的排序结果："+Arrays.toString(dogs));


         Cat[] cats = {new Cat(1,1),new Cat(5,9),new Cat(9,4),new Cat(7,2)};
        StrategySorter<Cat> catStrategySorterByHeight = new StrategySorter<Cat>();
        catStrategySorterByHeight.sort(cats,new StrategyCatComparatorByHeight());
        System.out.println("猫按照高度的排序结果："+Arrays.toString(cats));

    }
}
