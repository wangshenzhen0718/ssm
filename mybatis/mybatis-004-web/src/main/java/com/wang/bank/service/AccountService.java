package com.wang.bank.service;

import com.wang.bank.dao.exception.MoneyNotEnoughException;
import com.wang.bank.dao.exception.TransferNotSuccessException;

/**
 * @Author:wsz
 * @Date: 2022/11/6 22:21
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface AccountService {

    void transfer(String fromAct,String toAct,Double money) throws MoneyNotEnoughException, TransferNotSuccessException;
}
