package com.csurosefestival.domain.guestbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "GuestBook")
public class GuestBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB가 id(pk) 자동 생성
    private Long guestBookId;

    @Column(name="content", nullable = false, length = 255)
    private String content;

    @Column(name="nickName", nullable = false, length = 50)
    private String nickName;

    @Column(name="LocalDateTime")
    private LocalDateTime createDate;

//    @Column(nullable = false)
//    private Integer pw = 1234; //기본값 비밀번호 1234설정

    @Column(name = "reportedCount",nullable = false)
    private Integer reportedCount = 0; //기본값 설정

    //처음 생성될 때 자동으로 현재 날짜를 설정
    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }
}
