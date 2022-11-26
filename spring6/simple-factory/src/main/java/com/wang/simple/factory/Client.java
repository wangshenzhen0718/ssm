package com.wang.simple.factory;

public class Client {
    public static void main(String[] args) {
        Weapon weapon = WeaponFactory.get("TANK");
        weapon.attack();
    }
}
