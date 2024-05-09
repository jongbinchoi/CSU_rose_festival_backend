package com.csurosefestival.domain.guestbook.controller;

import com.csurosefestival.domain.guestbook.dto.GuestBookDTO;
import com.csurosefestival.domain.guestbook.dto.GuestBookRequest;
import com.csurosefestival.domain.guestbook.entity.GuestBook;
import com.csurosefestival.domain.guestbook.service.GuestBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guestbook")
public class GuestBookController {

    private final GuestBookService guestBookService;

    @GetMapping("/")
    public ResponseEntity<List<GuestBookDTO>> getAllGuestBooks() {
        List<GuestBookDTO> guestBooks = guestBookService.findAll();
        return ResponseEntity.ok(guestBooks);
    }

    @PostMapping("/add")
    public ResponseEntity<GuestBookDTO> createGuestBook(@RequestBody GuestBookRequest request) {
        GuestBookDTO savedGuestBook = guestBookService.saveGuestBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuestBook);
    }
}