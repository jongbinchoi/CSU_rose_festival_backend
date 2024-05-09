package com.csurosefestival.domain.totalvisit.controller;

import com.csurosefestival.domain.totalvisit.dto.VisitRecordDTO;
import com.csurosefestival.domain.totalvisit.entity.VisitRecord;
import com.csurosefestival.domain.totalvisit.service.VisitRecordServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VisitRecordController {

    private final VisitRecordServiceImpl visitRecordService;

    @GetMapping()
    public void visit(VisitRecord visitRecord){
        visitRecordService.visit(visitRecord);
    }
    @GetMapping("/visit-list")
    public List<VisitRecordDTO> visitList(){
        return visitRecordService.visitList();
    }

    @GetMapping("/daily-visit-statistics")
    public Long getDailyVisitStatistics() {
        return visitRecordService.getDailyVisitStatistics();
    }

}
