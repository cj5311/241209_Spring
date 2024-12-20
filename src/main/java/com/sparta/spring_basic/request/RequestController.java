package com.sparta.spring_basic.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class RequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // PathVariable 방식
    // GET http://localhost:8080/hello/request/star/Robbie/age/95
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age) {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    // RequestParam 방식
    // GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    // @RequestParam(required = false) 값이 없어도 에러나지 않도록 설정. 기본값 true로 지정되어 있음
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam(required = false) String name, int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // POST http://localhost:8080/hello/request/form/param
    // Header : Content type: application/x-www-form-urlencoded
    // Body : name=Robbie&age=95 -> 프론트에서 이 형식으로 데이터가 전달됨
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);

    }
}


