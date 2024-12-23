package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository 를 상속받고 있는 인터페이스
public interface MemoRepository extends JpaRepository<Memo, Long> {
    //원하는 쿼리를 생성해서 다른 객체에서 사용할 수 있다. 함수명으로 Sql 쿼리를 생성하여 SimpleJpaRepository에서 구현해줌.
    List<Memo> findAllByOrderByModifiedAtDesc();
    List<Memo> findAllByUsername(String username);
}