package com.wang.simple.factory;
/**
 * @Author:wsz
 * @Date: 2022/11/26 20:48
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class WeaponFactory {


    public static Weapon get(String weaponType){
        if (weaponType == null||weaponType.trim().length() == 0){
            return null;
        }
        Weapon weapon=null;
        if ("TANK".equals(weaponType)) {
            weapon = new Tank();
        } else if ("FIGHTER".equals(weaponType)) {
            weapon = new Fighter();
        } else if ("DAGGER".equals(weaponType)) {
            weapon = new Dagger();
        } else {
            throw new RuntimeException("不支持该武器！");
        }
        return weapon;
    }
}
