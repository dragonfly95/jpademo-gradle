package com.example.jpademo.web;


import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DeptController {

    @RequestMapping("test.do")
    public ResponseEntity test(@RequestBody ReqDto reqDto) {

        System.out.println("reqDto = " + reqDto);
        return ResponseEntity.ok(reqDto);
    }
}

@Getter
class ReqDto {
    private Date regDate;
}