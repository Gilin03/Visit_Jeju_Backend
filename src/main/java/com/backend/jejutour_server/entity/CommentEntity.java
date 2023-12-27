package com.backend.jejutour_server.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@Setter
@ToString
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment", length = 255)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_firebase_uid", referencedColumnName = "firebase_uid") // 수정된 부분
    private UserEntity user;


    // 기타 필요한 메서드나 필드
}
