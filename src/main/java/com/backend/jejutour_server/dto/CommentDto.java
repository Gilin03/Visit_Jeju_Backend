package com.backend.jejutour_server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private Long id;
    private String comment;
    private String userId;
    private String itemType;
    private Long itemId;
}
