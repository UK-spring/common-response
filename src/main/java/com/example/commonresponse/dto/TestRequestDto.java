package com.example.commonresponse.dto;

import lombok.Getter;

@Getter
public class TestRequestDto {

    private final String field1;

    private final String field2;

    public TestRequestDto(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
}
