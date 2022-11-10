package com.wang.bank.service.impl;

import com.wang.bank.dao.AccountDao;
import com.wang.bank.dao.exception.MoneyNotEnoughException;
import com.wang.bank.dao.exception.TransferNotSuccessException;
import com.wang.bank.pojo.Account;
import com.wang.bank.service.AccountService;
import com.wang.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
    //自己写的
    //private AccountDao accountDao= (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(),AccountDao.class);
    //在mybatis当中，mybatis提供了相关的机制。也可以动态为我们生成dao接口的实现类。(代理类: dao接口的代理)
    // mybatis当中实际上采用了代理模式。在内存中生成dao接口的代理类，然后创建代理类的实例。
    //使用mybatis的这种代理机制的前提:SqlMapper .xml文件中namespace必须是dao接口的全限定名称，id必须是dao接口中的方法名。
    //MyBatis自带
    private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);

    @Override
    public void transfer(String fromAct, String toAct, Double money) throws MoneyNotEnoughException, TransferNotSuccessException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account fromAccount = accountDao.selectById(Long.valueOf(fromAct));
        if (fromAccount.getBalance() < money) {
            throw new MoneyNotEnoughException("余额不足！！！");
        }
        Account toAccount = accountDao.selectById(Long.valueOf(toAct));
        fromAccount.setBalance(fromAccount.getBalance() - money);
        toAccount.setBalance(toAccount.getBalance() + money);

        int count = accountDao.updateAccount(fromAccount);
        //int a=2/0;
        count += accountDao.updateAccount(toAccount);
        if (count != 2) {
            throw new TransferNotSuccessException("转账异常，未知原因！！！");
        }
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);


    }
}
