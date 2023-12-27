package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // 필요한 추가 메서드들

    Optional<UserEntity> findByFirebaseUid(String firebaseUid);
}