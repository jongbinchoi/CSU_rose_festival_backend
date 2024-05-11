package com.csurosefestival.domain.report.service;

import com.csurosefestival.domain.guestbook.entity.GuestBook;
import com.csurosefestival.domain.guestbook.repository.GuestBookRepository;
import com.csurosefestival.domain.report.dto.DeleteGuestBookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {

    @Value("${admin.password}")
    private String PASSWORD;

    private final GuestBookRepository guestBookRepository;

    // 상위 10개 신고된 게시글 조회
    public List<GuestBook> findTop10ReportedGuestbook(){
        return guestBookRepository.findTop10ByOrderByReportedCountDesc();
    }

    // 신고 게시글 삭제
    public GuestBook deleteGuestBook(Long id, DeleteGuestBookDto dto) throws IllegalArgumentException{
        GuestBook target = guestBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID를 찾을 수 없습니다"));

        String pwd = target.getPw();
        if(dto.getPassword().equals(PASSWORD) || pwd.equals(dto.getPassword())){
            guestBookRepository.delete(target);
        }
        return target;
    }
}
