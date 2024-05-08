package com.csurosefestival.domain.totalvisit.service;


import com.csurosefestival.domain.totalvisit.dto.VisitRecordDTO;
import com.csurosefestival.domain.totalvisit.entity.VisitRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface VisitRecordService {

    void visit(VisitRecord visitRecord);
    List<VisitRecordDTO> visitList();
    Long getDailyVisitStatistics();
}
