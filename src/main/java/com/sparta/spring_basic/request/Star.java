package com.sparta.spring_basic.request;

import org.springframework.web.bind.annotation.*;

public class Star {
    String name;
    int age;

    public Star(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 데이터 형식이 querystring 방식일때
    // POST http://localhost:8080/hello/request/form/model
    // Header : Content type: application/x-www-form-urlencoded
    // Body : name=Robbie&age=95
    // 데이터를 객체로 변환
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    // GET http://localhost:8080/hello/request/form/param/model?name=Robbie&age=95
    @GetMapping("/form/param/model")
    @ResponseBody
    public String helloRequestParam(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    // 데이터가 json으로 넘어올때
    // POST http://localhost:8080/hello/request/form/json
    // Header : Content type: application/json
    // Body : {"name":"Robbie","age":"95"}
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }

}
