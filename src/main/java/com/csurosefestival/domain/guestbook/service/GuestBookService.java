package com.csurosefestival.domain.guestbook.service;

import com.csurosefestival.domain.guestbook.entity.GuestBook;
import com.csurosefestival.domain.guestbook.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;
    public List<GuestBook> findAllGuestBook() {
        return guestBookRepository.findAll();
    }

    @Transactional
    public GuestBook saveGuestBook(GuestBook guestBook) {
        log.info(guestBook.toString());
        return guestBookRepository.save(guestBook);
    }
}
