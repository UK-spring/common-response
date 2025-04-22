package com.example.commonresponse.dto;

import lombok.Getter;

@Getter
public class TestResponseDto {

    private final String message;

    public TestResponseDto(String message) {
        this.message = message;
    }
}
