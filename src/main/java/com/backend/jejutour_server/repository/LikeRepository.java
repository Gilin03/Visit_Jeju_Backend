package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    // Here you can define custom methods, for example:
    List<LikeEntity> findByTour_TourId(Long tourId);
}
