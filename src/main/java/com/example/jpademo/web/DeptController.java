package com.example.jpademo.web;


import com.example.jpademo.domain.Salgrade;
import com.example.jpademo.repository.SalGradeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@RestController
@RequiredArgsConstructor
public class DeptController {

    private final SalGradeRepository salGradeRepository;

    @GetMapping("test.do")
    public ModelAndView test() {
        ModelAndView modelAnd = new ModelAndView("test");
        return modelAnd;
    }

    @PostMapping("test.do")
    public ResponseEntity test(@RequestBody ReqDto reqDto, HttpServletRequest request) {

        Salgrade salGrade = Salgrade.builder()
                .hisal(Double.valueOf(100))
                .losal(Double.valueOf(10))
                .build();
        salGradeRepository.save(salGrade);

        System.out.println("reqDto = " + reqDto);
        Date regDate = reqDto.getRegDate();
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        LocalDateTime now = LocalDateTime.now(timeZone.toZoneId());
        reqDto.setLocalDate(now.toString());
        return ResponseEntity.ok(reqDto);
    }
}

@Getter
@Setter
class ReqDto {
    private Date regDate;
    private String localDate;
}