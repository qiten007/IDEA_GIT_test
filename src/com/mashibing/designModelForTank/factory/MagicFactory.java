package com.mashibing.designModelForTank.factory;

/**
 * @author hulinqi
 * @date 2020/5/4 --  23:38
 * @purpuse
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
