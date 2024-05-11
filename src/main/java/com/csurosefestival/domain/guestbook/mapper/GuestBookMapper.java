package com.csurosefestival.domain.guestbook.mapper;

import com.csurosefestival.domain.guestbook.dto.GuestBookDTO;
import com.csurosefestival.domain.guestbook.dto.GuestBookRequest;
import com.csurosefestival.domain.guestbook.entity.GuestBook;

import java.time.LocalDateTime;

public class GuestBookMapper {

    public static GuestBookDTO toDTO(GuestBook entity) {
        return GuestBookDTO.builder()
                .guestBookId(entity.getGuestBookId())
                .content(entity.getContent())
                .nickName(entity.getNickName())
                .reportedCount(entity.getReportedCount())
                .createDate(entity.getCreateDate())
                .pw(entity.getPw())
                .build();
    }

    // Request DTO -> Entity 변환
    public static GuestBook toEntity(GuestBookRequest dto) {
        return GuestBook.builder()
                .content(dto.getContent())
                .nickName(dto.getNickName())
                .createDate(LocalDateTime.now()) // 현재 시간으로 설정
                .reportedCount(0) // 기본값으로 0으로 설정
                .pw(dto.getPw())
                .build();
    }

            }
