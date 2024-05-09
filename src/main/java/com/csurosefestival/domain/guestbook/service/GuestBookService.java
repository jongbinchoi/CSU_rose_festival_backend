package com.csurosefestival.domain.guestbook.service;

import com.csurosefestival.domain.guestbook.dto.GuestBookDTO;
import com.csurosefestival.domain.guestbook.dto.GuestBookRequest;
import com.csurosefestival.domain.guestbook.entity.GuestBook;
import com.csurosefestival.domain.guestbook.mapper.GuestBookMapper;
import com.csurosefestival.domain.guestbook.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    public  List<GuestBookDTO> findAll() {
        return guestBookRepository.findAll().stream()
                .map(GuestBookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public GuestBookDTO saveGuestBook(GuestBookRequest request) {
        //Request DTO를 엔티티로 변환
        GuestBook guestBook = GuestBookMapper.toEntity(request);

        // 엔티티를 데이터베이스에 저장
        GuestBook savedGuestBook = guestBookRepository.save(guestBook);

        // 저장된 게시물 엔티티를 DTO로 변환하여 반환
        return GuestBookMapper.toDTO(savedGuestBook);
    }


}
