package com.example.commonresponse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    public void testV2(String field1, String field2) {

        if (field1 == null) {
            throw new IllegalArgumentException("요청 데이터의 feild1이 없습니다.");
        }

        if (field2 == null) {
            throw new IllegalArgumentException("요청 데이터의 feild1이 없습니다.");
        }

        log.info("field1, 2가 존재하는 경우 정상 로직 실행");

    }
}
