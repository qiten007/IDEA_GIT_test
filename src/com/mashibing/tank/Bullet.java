package com.mashibing.tank;

import java.awt.*;

/**
 * @author hulinqi
 * @date 2020/4/21 --  16:50
 * @purpuse
 */
public class Bullet {
    private static final int SPEED = 10;
    private int x,y;
    private Dir dir;
    public static final int WIDTH = ResourceManger.bulletD.getWidth(), HIGHT = ResourceManger.bulletD.getHeight();
    TankFrame tf = null;
    private boolean live = true;
    private Group group = Group.BAD;
    Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.WIDTH;
        rect.height = this.HIGHT;

        tf.bullets.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g){
        if(!live){
            tf.bullets.remove(this);
        }
        /*Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HIGHT);
        g.setColor(c);*/

        switch (dir){
            case LEFT:
                g.drawImage(ResourceManger.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceManger.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceManger.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceManger.bulletD,x,y,null);
                break;
        }

        move();
    }

    private void move() {
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

        rect.x = this.x;
        rect.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGTH) live = false;

    }

    //子弹与tank撞
    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) return;
        Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(rect1.intersects(tank.rect)){
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explore.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explore.HEIGHT / 2;
            tf.exploreList.add(new Explore(eX,eY,tf));
        }

    }

    private void die() {
        this.live = false;
    }
}
