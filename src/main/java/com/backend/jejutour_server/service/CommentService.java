package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.CommentEntity;
import com.backend.jejutour_server.entity.UserEntity;
import com.backend.jejutour_server.repository.CommentRepository;
import com.backend.jejutour_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentEntity saveComment(CommentEntity comment) {
        return commentRepository.save(comment);
    }
}
