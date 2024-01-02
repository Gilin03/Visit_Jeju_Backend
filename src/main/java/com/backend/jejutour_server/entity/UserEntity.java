package com.backend.jejutour_server.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class UserEntity implements Serializable {  // Serializable 인터페이스 구현

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long uid;

    @Column(name = "firebase_uid", unique = true)
    private String firebaseUid;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "email", length = 255)
    private String email;

    // 기타 필요한 메서드나 필드
}
