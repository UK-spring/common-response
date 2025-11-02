package com.example.commonresponse.controller;

import com.example.commonresponse.common.CommonResponse;
import com.example.commonresponse.dto.TestRequestDto;
import com.example.commonresponse.dto.TestResponseDto;
import com.example.commonresponse.exception.BusinessException;
import com.example.commonresponse.exception.CustomException;
import com.example.commonresponse.exception.ErrorCode;
import com.example.commonresponse.exception.SuccessCode;
import com.example.commonresponse.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/v1/test")
    public ResponseEntity<TestResponseDto> test(@RequestBody TestRequestDto dto) {

        if (dto.getField1() == null) {
            throw new IllegalArgumentException("요청 데이터의 feild1이 없습니다.");
        }

        if (dto.getField2() == null) {
            throw new IllegalArgumentException("요청 데이터의 feild2이 없습니다.");
        }

        log.info("field1, 2가 존재하는 경우 정상 로직 실행");

        return new ResponseEntity<>(new TestResponseDto("성공 응답"), HttpStatus.OK);

    }

    @PostMapping("/v2/test")
    public ResponseEntity<TestResponseDto> testV2(@RequestBody TestRequestDto dto) {

        try {
            testService.testV2(dto.getField1(), dto.getField2());
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new TestResponseDto("실패 응답"), HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(new TestResponseDto("성공 응답"), HttpStatus.OK);

    }

    @PostMapping("/v3/test")
    public ResponseEntity<TestResponseDto> testV3(@RequestBody TestRequestDto dto) {

        if (dto.getField1() == null) {
            throw new CustomException("field1이 존재하지 않습니다.");
        }

        return new ResponseEntity<>(new TestResponseDto("성공 응답"), HttpStatus.OK);

    }

    @PostMapping("/v4/test")
    public ResponseEntity<TestResponseDto> testV4(@RequestBody TestRequestDto dto) {

        if (dto.getField1() == null) {
            throw new BusinessException(ErrorCode.EMPTY_FIELD_EXCEPTION);
        }

        return new ResponseEntity<>(new TestResponseDto("성공 응답"), HttpStatus.OK);

    }

    @PostMapping("/v5/test")
    public CommonResponse<TestResponseDto> testV5(@RequestBody TestRequestDto dto) {

        return CommonResponse.of(SuccessCode.OK, new TestResponseDto("데이터"));

    }

    @PostMapping("/v6/test")
    public ResponseEntity<CommonResponse<TestResponseDto>> testV6(@RequestBody TestRequestDto dto) {

        return ResponseEntity
                .status(SuccessCode.OK.getStatus())
                .body(CommonResponse.of(SuccessCode.OK, new TestResponseDto("데이터")));

    }

}
