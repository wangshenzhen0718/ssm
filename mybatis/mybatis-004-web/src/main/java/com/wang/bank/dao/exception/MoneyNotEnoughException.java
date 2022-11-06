package com.wang.bank.dao.exception;
/**
 * @Author:wsz
 * @Date: 2022/11/6 22:35
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class MoneyNotEnoughException extends Exception{

    public MoneyNotEnoughException(){};
    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}
