package com.mashibing.designModelForTank.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author hulinqi
 * @date 2020/4/23 --  16:10
 * @purpuse
 */
public class LazyDemo {
    private static LazyDemo INSTANCE;

    private LazyDemo(){}

    public static LazyDemo getINSTANCE(){
        if(INSTANCE == null){
           /* try {  //注释部分模拟线程处理所花费时间
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            INSTANCE = new LazyDemo();
        }

        return INSTANCE;

    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++ ){
              new Thread(()->{
                  System.out.println(LazyDemo.getINSTANCE().hashCode());
              }, String.valueOf(i)).start();
          }
    }
}
