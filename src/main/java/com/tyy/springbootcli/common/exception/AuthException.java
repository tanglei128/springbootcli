package com.tyy.springbootcli.common.exception;

public class AuthException extends RuntimeException{
    public AuthException(){}
    public AuthException(String msg){
        super(msg);
    }
}
