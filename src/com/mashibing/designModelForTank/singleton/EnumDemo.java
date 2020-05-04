package com.mashibing.designModelForTank.singleton;

/**
 * @author hulinqi
 * @date 2020/4/23 --  17:38
 * @purpuse
 */
public enum EnumDemo {
    INSTANCE;

    public static void main(String[] args){
        for (int i = 0; i < 100; i++ ){
              new Thread(()->{
                  System.out.println(EnumDemo.INSTANCE.hashCode());
              }, String.valueOf(i)).start();
          }
    }
}
