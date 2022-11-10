package com.wang.bank.service.impl;

import com.wang.bank.dao.AccountDao;
import com.wang.bank.dao.exception.MoneyNotEnoughException;
import com.wang.bank.dao.exception.TransferNotSuccessException;
import com.wang.bank.pojo.Account;
import com.wang.bank.service.AccountService;
import com.wang.bank.utils.GenerateDaoProxy;
import com.wang.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao= (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(),AccountDao.class);
    @Override
    public void transfer(String fromAct, String toAct, Double money) throws MoneyNotEnoughException, TransferNotSuccessException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account fromAccount = accountDao.selectById(Long.valueOf(fromAct));
        if (fromAccount.getBalance()<money) {
            throw new MoneyNotEnoughException("余额不足！！！");
        }
        Account toAccount = accountDao.selectById(Long.valueOf(toAct));
        fromAccount.setBalance(fromAccount.getBalance()-money);
        toAccount.setBalance(toAccount.getBalance()+money);

        int count = accountDao.updateAccount(fromAccount);
        //int a=2/0;
        count+=accountDao.updateAccount(toAccount);
        if (count!=2){
            throw new TransferNotSuccessException("转账异常，未知原因！！！");
        }
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);


    }
}
