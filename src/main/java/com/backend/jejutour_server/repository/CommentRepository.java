package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.CommentEntity;
import com.backend.jejutour_server.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    // itemType과 itemId에 맞는 댓글을 조회하는 메서드
    List<CommentEntity> findByItemTypeAndItemId(String itemType, Long itemId);

}