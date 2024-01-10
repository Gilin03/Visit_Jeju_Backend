package com.backend.jejutour_server.service;

import com.backend.jejutour_server.dto.LikeDto;
import com.backend.jejutour_server.entity.LikeEntity;
import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.entity.UserEntity;
import com.backend.jejutour_server.repository.LikeRepository;
import com.backend.jejutour_server.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserService userService;
    private final TourService tourService;

    private final TourRepository tourRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository, UserService userService, TourService tourService, TourRepository tourRepository) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.tourService = tourService;
        this.tourRepository = tourRepository;
    }

    public LikeDto addLike(LikeDto likeDto) {
        UserEntity user = userService.findUserById(likeDto.getUserId());
        Optional<TourEntity> tourOptional = tourRepository.findById(likeDto.getTourId());

        if (tourOptional.isPresent()) {
            LikeEntity likeEntity = new LikeEntity();
            likeEntity.setUser(user);
            likeEntity.setTour(tourOptional.get());
            likeEntity.setCreatedAt(LocalDateTime.now());

            LikeEntity savedLike = likeRepository.save(likeEntity);
            return convertToDTO(savedLike);
        } else {
            // 적절한 예외 처리 또는 핸들링
            return null;
        }
    }

    public void removeLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }

    public List<LikeDto> getLikesByTour(Long tourId) {
        List<LikeEntity> likes = likeRepository.findByTour_TourId(tourId);
        return likes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private LikeDto convertToDTO(LikeEntity likeEntity) {
        LikeDto likeDTO = new LikeDto();
        likeDTO.setId(likeEntity.getId());
        likeDTO.setUserId(likeEntity.getUser().getUid());
        likeDTO.setTourId(likeEntity.getTour().getTourId());
        likeDTO.setCreatedAt(likeEntity.getCreatedAt());
        return likeDTO;
    }
}
