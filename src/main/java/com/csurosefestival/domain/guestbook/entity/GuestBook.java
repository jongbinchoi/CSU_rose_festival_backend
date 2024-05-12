package com.csurosefestival.domain.guestbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "guestBook") // 여기에 이름 명시
public class GuestBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id(pk) 자동 생성
    private Long guestBookId;

    @Column(name="content", nullable = false, length = 255)
    private String content;

    @Column(name="nickName", nullable = false, length = 50)
    private String nickName;

    @Column
    private String pw; //기본값 비밀번호 1234설정

    @Column(name="localDateTime") // 변경: 로컬 날짜 시간
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = "reportedCount",nullable = false)
    @Builder.Default
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 날짜 및 시간 형식 지정
    private Integer reportedCount = 0; // 기본값 설정

    @PrePersist
    protected void onCreate() {
        if (this.createDate == null) {
            this.createDate = LocalDateTime.now();
        }
        if (this.pw == null) {
            this.pw = "1234";
        }
    }

}
