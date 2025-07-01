package org.harsh.learning.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class LoginResponse {
    private final int loginId;
    private final int userId;
    private final LocalDateTime loginTime;
}
