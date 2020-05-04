package com.mashibing.designModelForTank.strategy;

/**
 * @author hulinqi
 * @date 2020/5/4 --  16:12
 * @purpuse
 */
public class Cat {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int comparerTo(Cat cat){
        if(this.weight < cat.weight){
            return -1;
        }else if(this.weight > cat.weight){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}

