package com.mashibing.tank;

import java.util.concurrent.TimeUnit;

/**
 * @author hulinqi
 * @date 2020/4/20 --  18:12
 * @purpuse
 */
public class T {
    public static void main(String[] args){
        TankFrame tf = new TankFrame();

        int initialTank = Integer.parseInt((String)PropertyManger.get("initialTank"));
        //初始化敌人坦克
        for (int i = 0; i < initialTank; i++ ){
            tf.enermies.add(new Tank(50 + i * 50,200,Dir.DOWN,tf,Group.BAD));
        }
        while (true){
            try{
                Thread.sleep(30);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            tf.repaint();
        }
    }

}
