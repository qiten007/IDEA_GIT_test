package com.mashibing.tank.fireStrategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Tank;

/**
 * @author hulinqi
 * @date 2020/5/4 --  21:39
 * @purpuse
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGHT / 2 - Bullet.HIGHT / 2;
        new Bullet(bX,bY,t.dir,t.tf,t.group);
    }
}
