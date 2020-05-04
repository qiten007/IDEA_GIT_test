package com.mashibing.designModelForTank.factory;

/**
 * @author hulinqi
 * @date 2020/5/4 --  23:37
 * @purpuse
 */
public class ModernFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
