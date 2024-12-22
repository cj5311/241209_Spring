package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//client 에서 ajax 요청을 줌.
//데이터만 넘겨주면 되기 때문에 Controller가 아닌 RestController 사용 -> 클래스의 모든 메서드에 @ResponseBody 애너테이션이 추가되는 기능
@RestController 
@RequestMapping("/api")
public class MemoController {

    // JDBC Template 사용 설정
    private final JdbcTemplate jdbcTemplate;

    public MemoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // 데이터 샘플 생성
    // Map<>: 키-값 쌍으로 저장하는 자료구조 , put, get, remove, containskey 로 접근
    // Hashmap<> : 키 중복없음, 값은 중복가능, 순서없음
    private final Map<Long,Memo> memoList = new HashMap<>();

    // 메모생성하기 API : RequestDto -> Entity -> ResponseDto
    // @RequestBody : Json 형태의 요청데이터를 객체로 받기 위함.
    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {

        // ReqestDto -> Entity (DB와 맵핑되는 객체, JPA같은 ORM(Object-Relational Mapping) 기술에서 사용되는 개념)
        // requestDto를 인수로 사용하여 객체를 생성해 준다.
        Memo memo = new Memo(requestDto);

        //memo 객체에 id 값 생성해 주기
        //메모리스트에 데이터가 있으면, 키값의 최대값+1 을 사용하고, 데이터가 없으면 1로 설정 (1번부터 순서대로 번호 생성)
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) +1 : 1;
        memo.setId(maxId);

        //DB 저장하기
        memoList.put(maxId, memo);
        
        //Entity --> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;

    }

    // 메모조회하기 API
    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        // Map To List
        // Stream() 값들을 for문처럼 하나하나 반환시켜준다 / map() : 타입변환 (객체로 생성시켜줌) / toList() 리트스로 타입변환
        List<MemoResponseDto> responseList = memoList.values().stream()
                .map(MemoResponseDto::new).toList();

        return responseList;
    }

    //수정하기 API
    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        if(memoList.containsKey(id)) {
            // 해당 메모 가져오기
            Memo memo = memoList.get(id);

            // memo 수정
            memo.update(requestDto);
            return memo.getId();
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    //삭제하기 api
    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        if(memoList.containsKey(id)) {
            // 해당 메모 삭제하기
            memoList.remove(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

}