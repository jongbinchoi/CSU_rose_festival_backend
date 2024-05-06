package com.csurosefestival.domain.guestbook.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class GuestBookDTO {
    private Long guestBookId;
    private String content;
    private String nickName;
//    private Integer pw;
    private Integer reportedCount;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") //JSON 처리 시 포맷팅 지정
    private LocalDateTime createDate;
}
