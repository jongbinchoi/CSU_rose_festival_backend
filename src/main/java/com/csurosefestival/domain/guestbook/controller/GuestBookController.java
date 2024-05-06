package com.csurosefestival.domain.guestbook.controller;

import com.csurosefestival.domain.guestbook.entity.GuestBook;
import com.csurosefestival.domain.guestbook.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guestbook")
public class GuestBookController {

    private final GuestBookService guestBookService;


}
