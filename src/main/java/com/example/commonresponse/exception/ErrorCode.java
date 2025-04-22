package com.example.commonresponse.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode implements BaseCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저가 존재하지 않습니다."),
    CONFLICT_USER(HttpStatus.CONFLICT, "이미 존재하는 유저입니다."),
    EMPTY_FIELD_EXCEPTION(HttpStatus.BAD_REQUEST, "입력 값이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
