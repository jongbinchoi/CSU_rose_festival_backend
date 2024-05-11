package com.csurosefestival.domain.guestbook.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestBookRequest {
    private String content;
    private String nickName;
    private String pw;


}
