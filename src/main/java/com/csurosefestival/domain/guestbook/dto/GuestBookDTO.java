package com.csurosefestival.domain.guestbook.dto;

import com.csurosefestival.domain.guestbook.entity.GuestBook;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Getter
public class GuestBookDTO {
    private Long guestBookId;
    private String content;
    private String nickName;
    private Integer reportedCount;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") //JSON 처리 시 포맷팅 지정
    private LocalDateTime createDate;
}