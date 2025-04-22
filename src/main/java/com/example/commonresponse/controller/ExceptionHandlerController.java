package com.example.commonresponse.controller;

import com.example.commonresponse.service.ExceptionHandlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ExceptionHandlerController {

    private final ExceptionHandlerService exceptionHandlerService;

    /**
     * throw new IllegalArgumentException
     */
    @RequestMapping("/v1/exception")
    public void illegalArgumentException() {

        throw new IllegalArgumentException("IllegalArgumentException 발생");
    }

    /**
     * API 호출에 성공해서 데이터를 반환받은 경우
     * @return
     */
    @RequestMapping("/success")
    public ResponseEntity<String> success() {

        return new ResponseEntity<>("asdfsdf", HttpStatus.OK);
    }

    /**
     * NPE
     */
    @RequestMapping("/v2/exception")
    public void nullPointerException() {

        throw new NullPointerException("NPE 발생"); // 없다.
    }

    /**
     * ServiceLayer에서 throw new IllegalArgumentException을 하는 경우
     */
    @RequestMapping("/v3/exception")
    public void serviceLayerException() {

        exceptionHandlerService.throwNewIllegalArgumentException();
    }

    // IllegalArgumentException을 처리하는 메서드 try-catch
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {

        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

}