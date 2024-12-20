package com.sparta.spring_basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.spring_basic.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JacksonTest {

    @Test
    @DisplayName("Object To JSON : get Method 필요")
    void test1() throws JsonProcessingException {

        Star star = new Star("Robbie", 95);

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper
        String json = objectMapper.writeValueAsString(star); // 객체를 스트링으로 변환

        System.out.println("json = " + json);
    }

    @Test
    @DisplayName("JSON To Object : 기본 생성자 & (get OR set) Method 필요")
    void test2() throws JsonProcessingException {

        String json = "{\"name\":\"Robbie\",\"age\":95}";

        ObjectMapper objectMapper = new ObjectMapper();

        Star star = objectMapper.readValue(json, Star.class); //스트링을 객체로 생성
        System.out.println("star.getName() = " + star.getName());
    }
}
