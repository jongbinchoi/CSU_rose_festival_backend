package com.csurosefestival.domain.guestbook.controller;

import com.csurosefestival.domain.guestbook.dto.GuestBookDTO;
import com.csurosefestival.domain.guestbook.entity.GuestBook;
import com.csurosefestival.domain.guestbook.service.GuestBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public List<GuestBookDTO> getAllGuestBook() {
        return guestBookService.findAllGuestBook();
    }

    @PostMapping("/add")
    public ResponseEntity<GuestBook> addGuestBook(@Valid @RequestBody GuestBook guestBook, BindingResult bindingResult){//binding Result유효성 검사 결과를 담는 객체
        //유효성 검사 수행
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        GuestBook savedGuestBook = guestBookService.saveGuestBook(guestBook);
        return ResponseEntity.ok(savedGuestBook);
    }
}