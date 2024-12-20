package com.sparta.spring_basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller: View 반환할때 vs RestController : data 반환할때
@RestController
@RequestMapping("/response")
public class ResponseController {


    @GetMapping("/json/string")
//    @ResponseBody // @Controller 에서 @RestController 로 변경시 생략가능
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
        // 서버에서 json 형식을 읽을 수 없기 때문에 String으로 처리
        // [Response header] : Content-Type: text/html
        // [Response body] :  {"name":"Robbie","age":95}
    }

    @GetMapping("/json/class")
//    @ResponseBody // html 이 아닌 데이터 반환임을 설정
    public Star helloClassJson() {
        return new Star("Robbie", 95);
        // [Response header] : Content-Type: application/json
        // [Response body] :  {"name":"Robbie","age":95}
    }
}