package com.backend.jejutour_server.controller;

import com.backend.jejutour_server.dto.LikeDto;
import com.backend.jejutour_server.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<LikeDto> addLike(@RequestBody LikeDto likeDto) {
        LikeDto createdLike = likeService.addLike(likeDto);
        if (createdLike != null) {
            return ResponseEntity.ok(createdLike);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<Void> removeLike(@PathVariable Long likeId) {
        likeService.removeLike(likeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tour/{tourId}")
    public ResponseEntity<List<LikeDto>> getLikesByTour(@PathVariable Long tourId) {
        List<LikeDto> likes = likeService.getLikesByTour(tourId);
        return ResponseEntity.ok(likes);
    }
}
