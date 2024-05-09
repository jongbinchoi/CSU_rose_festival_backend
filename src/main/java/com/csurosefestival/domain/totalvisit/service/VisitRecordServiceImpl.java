package com.csurosefestival.domain.totalvisit.service;

import com.csurosefestival.domain.totalvisit.dto.VisitRecordDTO;
import com.csurosefestival.domain.totalvisit.entity.VisitRecord;
import com.csurosefestival.domain.totalvisit.repository.VisitRecodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class VisitRecordServiceImpl implements VisitRecordService{

    private final VisitRecodeRepository visitRecodeRepository;

    @Override
    public void visit(VisitRecord visitRecord) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        visitRecord.setVisitDate(localDate);
        visitRecord.setVisitDateDetail(localDateTime);
        visitRecodeRepository.save(visitRecord);
    }



    @Override
    public List<VisitRecordDTO> visitList() {
        List<VisitRecordDTO> dtoList = visitRecodeRepository.countByVisitDate();
        return dtoList;
    }

    @Override
    public Long getDailyVisitStatistics() {
        LocalDate today = LocalDate.now();
        return visitRecodeRepository.countByVisitDate(today);
    }

    public void printDailyVisitStatistics() {
        Long dailyVisitStatistics = this.getDailyVisitStatistics();
        System.out.println("Daily Visit Statistics: " + dailyVisitStatistics);
    }

//    @Override
//    public void visit(VisitRecord visitRecord){
//        visitRecodeRepository.save(visitRecord);
//    }
//
//    @Override
//    public void visit(LocalDateTime visitDateTime) {
//        VisitRecord visitRecord = new VisitRecord();
//        visitRecord.setVisitDate(visitDateTime);
//        visitRecord.increaseVisitCount();
//        visitRecodeRepository.save(visitRecord);
//    }
//
//    @Override
//    public List<VisitRecordDTO> visitList() {
//        List<VisitRecord> visitRecords = visitRecodeRepository.findAll();
//        visitRecords.forEach(VisitRecord::getDayOfWeek);
//
//        return visitRecords.stream()
//            .collect(Collectors.groupingBy(VisitRecord::getDayOfWeek))
//            .entrySet().stream()
//            .map(entry -> new VisitRecordDTO(entry.getValue().get(0).getVisitDate(),calculateTotalVisits(entry.getValue()), entry.getKey()))
//            .collect(Collectors.toList());
//
//    }
//
//    private Long calculateTotalVisits(List<VisitRecord> visitRecords) {
//        return visitRecords.stream()
//                .mapToLong(VisitRecord::getVisitCount)
//                .sum();
//    }

}
