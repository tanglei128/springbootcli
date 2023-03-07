package com.tyy.springbootcli.common.exception;

public class BusinessException  extends RuntimeException{
    public BusinessException(){

    }
    public BusinessException(String reason){
        super(reason);
    }
}
