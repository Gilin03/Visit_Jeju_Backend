package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.CommentEntity;
import com.backend.jejutour_server.entity.UserEntity;
import com.backend.jejutour_server.repository.CommentRepository;
import com.backend.jejutour_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentEntity saveComment(CommentEntity comment) {
        return commentRepository.save(comment);
    }

    // itemType과 itemId에 맞는 댓글을 조회하는 서비스 메서드
    public List<CommentEntity> getCommentsByItemTypeAndItemId(String itemType, Long itemId) {
        return commentRepository.findByItemTypeAndItemId(itemType, itemId);
    }
}
