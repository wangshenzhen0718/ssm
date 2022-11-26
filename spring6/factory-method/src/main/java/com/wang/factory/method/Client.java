package com.wang.factory.method;

public class Client {
    public static void main(String[] args) {

        WeaponFactory daggerFactory=new DaggerFactory();
        Weapon dagger = daggerFactory.get();
        dagger.attack();

        WeaponFactory tankFactory=new TankFactory();
        Weapon tank = tankFactory.get();
        tank.attack();


    }
}
