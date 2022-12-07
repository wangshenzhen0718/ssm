package com.wang.bank.service;

import com.wang.bank.pojo.Account;

public interface AccountService {

    /**
     * 转账
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno, String toActno, double money);

    void save(Account account);
}