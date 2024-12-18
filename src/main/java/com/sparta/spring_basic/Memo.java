package com.sparta.spring_basic;
import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
public class Memo {
    private final String username;
    private String contents;
}
