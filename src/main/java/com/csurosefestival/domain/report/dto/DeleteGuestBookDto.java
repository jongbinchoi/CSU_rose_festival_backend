package com.csurosefestival.domain.report.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteGuestBookDto {
    @NotBlank(message = "비밀번호는 필수 값 입니다") // null, "", " " 이 아닌 경우 통과
    @Size(min = 0, max = 20, message = "비밀번호는 1자~20자의 비밀번호이어야 합니다")
    String pw;
}
