package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.CommentEntity;
import com.backend.jejutour_server.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {


}