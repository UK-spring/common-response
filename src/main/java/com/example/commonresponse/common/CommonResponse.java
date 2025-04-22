package com.example.commonresponse.common;

import com.example.commonresponse.exception.BaseCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonResponse<T> {

    private final HttpStatus httpStatus;
    private final String message;
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    private CommonResponse(HttpStatus httpStatus, String message, T data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> of(BaseCode code, T data) {
        return new CommonResponse<>(code.getStatus(), code.getMessage(), data);
    }

    public static <T> CommonResponse<T> of(BaseCode code) {
        return of(code, null);
    }

}
