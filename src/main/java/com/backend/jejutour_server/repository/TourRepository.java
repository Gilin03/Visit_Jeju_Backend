package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<TourEntity,Long>, TourRepositoryCustom {
//    @Query("select m.name from TourEntity m")
//    List<String> findNameList();
List<TourEntity> findByItemsRegion2CdValue(Long region2cd_label);
}