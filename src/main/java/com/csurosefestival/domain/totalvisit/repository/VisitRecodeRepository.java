package com.csurosefestival.domain.totalvisit.repository;

import com.csurosefestival.domain.totalvisit.entity.VisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRecodeRepository extends JpaRepository<VisitRecord,Long> {
}
