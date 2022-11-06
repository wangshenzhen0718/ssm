package com.wang.bank.dao.exception;

public class TransferNotSuccessException extends Exception{
    public TransferNotSuccessException(){};
    public TransferNotSuccessException(String msg){
        super(msg);
    }
}