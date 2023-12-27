package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.UserEntity;
import com.backend.jejutour_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity findUserByFirebaseUid(String firebaseUid) {
        // Firebase 사용자 ID를 기반으로 사용자 조회
        return userRepository.findByFirebaseUid(firebaseUid).orElse(null);
    }

}
