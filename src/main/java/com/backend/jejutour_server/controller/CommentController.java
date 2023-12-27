package com.backend.jejutour_server.controller;


import com.backend.jejutour_server.dto.CommentDto;
import com.backend.jejutour_server.dto.UserDto;
import com.backend.jejutour_server.entity.CommentEntity;
import com.backend.jejutour_server.entity.UserEntity;
import com.backend.jejutour_server.service.CommentService;
import com.backend.jejutour_server.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService; // UserService 주입

    @PostMapping("/save")
    public ResponseEntity<CommentEntity> saveComment(@RequestBody CommentDto commentDto) {
        UserEntity user = userService.findUserByFirebaseUid(commentDto.getUserId());
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        CommentEntity comment = new CommentEntity();
        comment.setComment(commentDto.getComment());
        comment.setUser(user);
        comment.setItemType(commentDto.getItemType());
        comment.setItemId(commentDto.getItemId());

        CommentEntity savedComment = commentService.saveComment(comment);
        return ResponseEntity.ok(savedComment);
    }

}