package com.csurosefestival.domain.totalvisit.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class VisitRecordDTO {
    @JsonFormat(pattern="yyyy-MM-dd ")
    private LocalDate visitDate;
    private Long visitCount;
}
