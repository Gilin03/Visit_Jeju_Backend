package com.backend.jejutour_server.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class LikeDto {

    private Long id;
    private Long userId;
    private Long tourId;
    private LocalDateTime createdAt;


}
