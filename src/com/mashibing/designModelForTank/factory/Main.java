package com.mashibing.designModelForTank.factory;


/**
 * @author hulinqi
 * @date 2020/5/4 --  22:18
 * @purpuse
 */
public class Main {
    public static void main(String[] args){
        //new Car().go();
        //new Plan().go();
       /*
        Movable m = new Broom();
        m.go();

        AK47 ak = new AK47();
        ak.shot();

        Bread b = new Bread();
        b.printName();*/

       AbstractFactory modernFactory = new ModernFactory();

        Food food = modernFactory.createFood();
        food.printName();

        Vehicle vehicle = modernFactory.createVehicle();
        vehicle.go();

        Weapon weapon = modernFactory.createWeapon();
        weapon.shot();


    }
}
