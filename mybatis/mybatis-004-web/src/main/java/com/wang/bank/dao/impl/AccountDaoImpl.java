package com.wang.bank.dao.impl;

import com.wang.bank.dao.AccountDao;
import com.wang.bank.pojo.Account;
import com.wang.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectById(Long id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Account account = sqlSession.selectOne("account.selectById",id);
        sqlSession.close();
        return account;
    }

    @Override
    public int updateAccount(Account account) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int row = sqlSession.update("account.updateById",account);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public int insertAccount(Account account) {
        return 0;
    }
}
