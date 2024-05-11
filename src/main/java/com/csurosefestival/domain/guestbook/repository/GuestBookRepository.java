package com.csurosefestival.domain.guestbook.repository;

import com.csurosefestival.domain.guestbook.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestBookRepository extends JpaRepository<GuestBook, Long> {
    List<GuestBook> findTop50ByOrderByCreateDateDesc();
    List<GuestBook> findTop10ByOrderByReportedCountDesc();
}
