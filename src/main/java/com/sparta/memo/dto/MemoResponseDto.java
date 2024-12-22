package com.sparta.memo.dto;

import com.sparta.memo.entity.Memo;
import lombok.Getter;

//db와 통신하는 데이터는 매우 중요하기 때문에 Memo 클레스에서 변수 선언한것과 동일하게 dto 에서 변수 한번더 선언해 준다.
@Getter
public class MemoResponseDto {
    private Long id;
    private String username;
    private String contents;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
    }

    public MemoResponseDto(Long id, String username, String contents) {
        this.id = id;
        this.username = username;
        this.contents = contents;
    }
}