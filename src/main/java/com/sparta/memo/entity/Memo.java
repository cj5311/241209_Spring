package com.sparta.memo.entity;

import com.sparta.memo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

//데이터와 소통할 클래스
@Getter
@Setter
@NoArgsConstructor
public class Memo {

    // 저장할 데이터 정의 : id, username, contents
    private Long id;
    private String username;
    private String contents;

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername();
    }
}