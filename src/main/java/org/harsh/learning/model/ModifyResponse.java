package org.harsh.learning.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ModifyResponse {
    private final int modifyId;
    private final int userId;
    private final LocalDateTime modifyTime;
}