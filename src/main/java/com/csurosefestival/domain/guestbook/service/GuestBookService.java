package com.csurosefestival.domain.guestbook.service;

import com.csurosefestival.domain.guestbook.dto.GuestBookDTO;
import com.csurosefestival.domain.guestbook.dto.GuestBookRequest;
import com.csurosefestival.domain.guestbook.dto.ReportGuestBookRequest;
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

    public List<GuestBookDTO> findAll() {
        return guestBookRepository.findAll().stream()
                .map(GuestBookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public GuestBookDTO saveGuestBook(GuestBookRequest request) {
        try {
            // Request DTO를 엔티티로 변환
            GuestBook guestBook = GuestBookMapper.toEntity(request);

            // 엔티티를 데이터베이스에 저장
            GuestBook savedGuestBook = guestBookRepository.save(guestBook);

            // 저장된 게시물 엔티티를 DTO로 변환하여 반환
            return GuestBookMapper.toDTO(savedGuestBook);
        } catch (Exception e) {
            log.error("방명록 등록 에러 발생", e);
            throw new RuntimeException("방명록 등록 실패", e);
        }
    }

    public GuestBookDTO reportGuestBook(ReportGuestBookRequest request) {
        GuestBook guestBook = guestBookRepository.findById(request.getGuestBookId()).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 방명록게시물 ID: " + request.getGuestBookId()));
        int currentReportedCount = guestBook.getReportedCount();
        guestBook.setReportedCount(currentReportedCount + 1);
        GuestBook updatedReport = guestBookRepository.save(guestBook);

        //간단하게 아래 처럼도 가능
//        guestBook.setReportedCount(guestBook.getReportedCount() + 1);
//        GuestBook updatedReport = guestBookRepository.save(guestBook);

        return GuestBookMapper.toDTO(updatedReport);
    }
}
