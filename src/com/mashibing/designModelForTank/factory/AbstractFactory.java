package com.mashibing.designModelForTank.factory;

/**
 * @author hulinqi
 * @date 2020/5/4 --  22:46
 * @purpuse
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();

}
