package com.csurosefestival.domain.totalvisit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "VisitRecord")
@Entity
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitId;

    @Column(name = "daliyVisits",nullable = false)
    private Long daliyVisits;

    @Column(name = "totalVisits",nullable = false)
    private Long totalVisits;

    @Column(name = "visitDate")
    private LocalDateTime visitDate;
}
