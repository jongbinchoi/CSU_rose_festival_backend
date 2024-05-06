package com.csurosefestival.domain.guestbook.mapper;

import com.csurosefestival.domain.guestbook.dto.GuestBookDTO;
import com.csurosefestival.domain.guestbook.entity.GuestBook;

public class GuestBookMapper {

    public static GuestBookDTO toDTO(GuestBook entity) {
        return GuestBookDTO.builder()
                .guestBookId(entity.getGuestBookId())
                .content(entity.getContent())
                .nickName(entity.getNickName())
                .reportedCount(entity.getReportedCount())
                .createDate(entity.getCreateDate())
                .build();
    }

    public static GuestBook toEntity(GuestBookDTO dto) {
        return GuestBook.builder()
                .guestBookId(dto.getGuestBookId())
                .content(dto.getContent())
                .nickName(dto.getNickName())
                .reportedCount(dto.getReportedCount())
                .createDate(dto.getCreateDate())
                .build();
    }
}
