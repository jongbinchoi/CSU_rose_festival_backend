package com.csurosefestival.domain.totalvisit.repository;

import com.csurosefestival.domain.totalvisit.dto.VisitRecordDTO;
import com.csurosefestival.domain.totalvisit.entity.VisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisitRecodeRepository extends JpaRepository<VisitRecord,Long> {

        @Query(value =
                "SELECT new com.csurosefestival.domain.totalvisit.dto.VisitRecordDTO(v.visitDate, count(v)) " +
                "FROM VisitRecord v " +
                "GROUP BY v.visitDate")
        List<VisitRecordDTO> countByVisitDate();

        Long countByVisitDate(LocalDate date);

}
