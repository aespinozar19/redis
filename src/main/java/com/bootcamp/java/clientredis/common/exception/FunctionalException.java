package com.bootcamp.java.clientredis.common.exception;

public class FunctionalException extends RuntimeException{
    public FunctionalException(String messageError){
        super(messageError);
    }
}
