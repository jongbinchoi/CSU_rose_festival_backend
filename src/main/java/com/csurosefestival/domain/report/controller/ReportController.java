package com.csurosefestival.domain.report.controller;

import com.csurosefestival.domain.guestbook.entity.GuestBook;
import com.csurosefestival.domain.report.dto.DeleteGuestBookDto;
import com.csurosefestival.domain.report.service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReportController {

    private final ReportService reportService;

    @DeleteMapping("/api/guestbook/{id}")
    public ResponseEntity<GuestBook> deleteGuestBook(@PathVariable Long id, @RequestBody @Valid DeleteGuestBookDto dto){
        GuestBook deleted = reportService.deleteGuestBook(id, dto);

        return ResponseEntity.ok().body(deleted);
    }

    @GetMapping("/api/guestbook/report")
    public ResponseEntity<List<GuestBook>> findTop10ReportedGuestbook(){
        return ResponseEntity.ok().body(reportService.findTop10ReportedGuestbook());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumentException(Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Valid 예외 발생 시 예외 처리하는 부분
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        List<String> result = bindingResult.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        log.error(e.getMessage());
        log.error("{}",result);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
