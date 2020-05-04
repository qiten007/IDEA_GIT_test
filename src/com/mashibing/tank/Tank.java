package com.mashibing.tank;

import com.mashibing.tank.fireStrategy.DefaultFireStrategy;
import com.mashibing.tank.fireStrategy.FireStrategy;
import com.mashibing.tank.fireStrategy.FourDirFireStrategy;

import java.awt.*;
import java.util.Properties;
import java.util.Random;

/**
 * @author hulinqi
 * @date 2020/4/20 --  22:06
 * @purpuse
 */
public class Tank {
    public int x,y;
    public Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    public TankFrame tf = null;
    private boolean liveing = true;
    private Random random = new Random();
    public Group group = Group.BAD;

    FireStrategy fs = new DefaultFireStrategy();

    public Rectangle rect = new Rectangle();
    private boolean moving = true;
    public static int WIDTH = ResourceManger.badTankU.getWidth();
    public static int HEIGHT = ResourceManger.badTankU.getHeight();

    public Tank(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.WIDTH;
        rect.height = this.HEIGHT;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isLiveing() {
        return liveing;
    }

    public void setLiveing(boolean liveing) {
        this.liveing = liveing;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillRect(x,y,50,50);
//        g.setColor(c);
        if(!liveing) tf.enermies.remove(this);

        switch (dir){
            case LEFT:
                g.drawImage(this.group==Group.GOOD?ResourceManger.goodTankL:ResourceManger.badTankL,x,y,null);
                break;
            case UP:
                g.drawImage(this.group==Group.GOOD?ResourceManger.goodTankU:ResourceManger.badTankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.GOOD?ResourceManger.goodTankR:ResourceManger.badTankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group==Group.GOOD?ResourceManger.goodTankD:ResourceManger.badTankD,x,y,null);
                break;
        }

        move();
    }

    private void move() {
        if(!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        if(this.group == Group.BAD && random.nextInt(100) > 95){
            this.fire();
            //if(this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();
        }

        boundCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    //边界检查
    private void boundCheck() {
        if(this.x < 3) x = 3;
        if(this.y < 3) y = 3;
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 3) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 3;
        if(this.y > TankFrame.GAME_HEIGTH -Tank.HEIGHT - 3) y = TankFrame.GAME_HEIGTH - Tank.HEIGHT - 3;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        /*if(this.group==Group.GOOD){
            fs = new FourDirFireStrategy();
        }*/
        //可以使用配置文件的方式来使用不同的策略模式
        if(this.group==Group.GOOD){
            String fsName = (String)PropertyManger.get("goodFs");
            try {
                fs = (FireStrategy) Class.forName(fsName).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        fs.fire(this);
    }

    public void die() {
      this.liveing = false;
    }
}
