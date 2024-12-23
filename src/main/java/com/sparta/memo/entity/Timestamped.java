package com.sparta.memo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // 자동으로 시간 넣어주는 기능
public abstract class Timestamped {

    @CreatedDate // 시간객체 생성
    @Column(updatable = false) // 시간 업데이트 방지
    @Temporal(TemporalType.TIMESTAMP) // date, time, timestamp 데이터 맵핑할때 사용
    private LocalDateTime createdAt;

    @LastModifiedDate // 변경된 시간 저장
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;
}