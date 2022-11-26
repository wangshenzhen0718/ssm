package com.wang.factory.method;
/**
 * @Author:wsz
 * @Date: 2022/11/26 21:13
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class TankFactory implements  WeaponFactory{

    @Override
    public Weapon get() {
        return new Tank();
    }
}
