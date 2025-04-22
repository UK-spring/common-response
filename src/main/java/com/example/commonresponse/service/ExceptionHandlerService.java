package com.example.commonresponse.service;

import org.springframework.stereotype.Service;

@Service
public class ExceptionHandlerService {

    public void throwNewIllegalArgumentException() {
        throw new IllegalArgumentException("Service에서 Exception 발생");

    }

}
