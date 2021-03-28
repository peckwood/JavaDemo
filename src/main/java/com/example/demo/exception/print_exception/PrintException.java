package com.example.demo.exception.print_exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PrintException{
    private static final Logger logger = LogManager.getLogger(PrintException.class);

    public static void main(String[] args){
        try{
            throwMyException();
        }catch(Exception e){
            logger.error("除零异常: ", e);
        }
    }

    static void throwMyException(){
        int a = 1 / 0;
    }
}
