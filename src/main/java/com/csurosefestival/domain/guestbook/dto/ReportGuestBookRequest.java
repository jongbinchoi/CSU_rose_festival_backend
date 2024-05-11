package com.csurosefestival.domain.guestbook.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportGuestBookRequest {
    @NotNull
    private Long guestBookId;
}
