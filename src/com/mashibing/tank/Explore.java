package com.mashibing.tank;

import java.awt.*;

/**
 * @author hulinqi
 * @date 2020/4/21 --  22:09
 * @purpuse
 */
public class Explore {
    public static int WIDTH = ResourceManger.explores[0].getWidth();
    public static int HEIGHT = ResourceManger.explores[0].getHeight();
    private int x,y;
    TankFrame tf = null;
    private boolean live = true;
    private int step = 0;


    public Explore(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {

        g.drawImage(ResourceManger.explores[step++], x, y, null);

        if(step >= ResourceManger.explores.length)
            tf.exploreList.remove(this);


    }

   /* public void paint(Graphics g){
        g.drawImage(ResourceManger.explores[step++],x,y,null);
        if(step >= ResourceManger.explores.length){
            tf.exploreList.remove(this);
        }
    }*/
}
