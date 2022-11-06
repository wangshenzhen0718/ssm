package com.wang.bank.service.impl;

import com.wang.bank.dao.AccountDao;
import com.wang.bank.dao.exception.MoneyNotEnoughException;
import com.wang.bank.dao.exception.TransferNotSuccessException;
import com.wang.bank.dao.impl.AccountDaoImpl;
import com.wang.bank.pojo.Account;
import com.wang.bank.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao=new AccountDaoImpl();
    @Override
    public void transfer(String fromAct, String toAct, Double money) throws MoneyNotEnoughException, TransferNotSuccessException {
        Account fromAccount = accountDao.selectById(Long.valueOf(fromAct));
        if (fromAccount.getBalance()<money) {
            throw new MoneyNotEnoughException("余额不足！！！");
        }
        Account toAccount = accountDao.selectById(Long.valueOf(toAct));
        fromAccount.setBalance(fromAccount.getBalance()-money);
        toAccount.setBalance(toAccount.getBalance()+money);

        int count = accountDao.updateAccount(fromAccount);
        count+=accountDao.updateAccount(toAccount);
        if (count!=2){
            throw new TransferNotSuccessException("转账异常，未知原因！！！");
        }


    }
}
