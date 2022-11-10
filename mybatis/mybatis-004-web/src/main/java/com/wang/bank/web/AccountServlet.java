package com.wang.bank.web;

import com.wang.bank.dao.exception.MoneyNotEnoughException;
import com.wang.bank.dao.exception.TransferNotSuccessException;
import com.wang.bank.service.AccountService;
import com.wang.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2022/11/6 21:44
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
//@WebServlet("transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收前端传来的参数
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        Double money = Double.parseDouble(request.getParameter("money"));
        try {
            accountService.transfer(fromActno, toActno, money);
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");
        } catch (TransferNotSuccessException e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");
        }
    }
}
