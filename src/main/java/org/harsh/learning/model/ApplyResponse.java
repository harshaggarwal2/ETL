package org.harsh.learning.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ApplyResponse {
    private final int applyId;
    private final int userId;
    private final LocalDateTime applyTime;
}
