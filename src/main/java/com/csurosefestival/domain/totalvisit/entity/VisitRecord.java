package com.csurosefestival.domain.totalvisit.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.data.annotation.Transient;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(value ={AuditingEntityListener.class})
@Table(name = "VisitRecord")
@Entity
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visitId")
    private Long visitId;

    @CreatedDate
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "visitDateDetail")
    private LocalDateTime visitDateDetail;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "visitDate")
    private LocalDate visitDate;


}
