package com.hunghoang.homerental.entities;

import com.hunghoang.homerental.model.UserStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "rental", catalog = "postgres")
@Data
@EqualsAndHashCode
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "dob")
    private Timestamp dob;
    @Basic
    @Column(name = "avatar")
    private Long avatar;
    @Basic
    @Column(name = "id_type")
    private String idType;
    @Basic
    @Column(name = "id_number")
    private String idNumber;
    @Basic
    @Column(name = "id_expired_date")
    private Timestamp idExpiredDate;
    @Basic
    @Column(name = "id_issuer")
    private String idIssuer;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Basic
    @Column(name = "address_id")
    private Integer addressId;
    @Basic
    @Column(name = "created")
    @CreatedDate
    private OffsetDateTime created;
    @Basic
    @Column(name = "type")
    private Integer type;
    @Basic
    @Column(name = "provider")
    private String provider;
    @Basic
    @Column(name = "provider_id")
    private String providerId;
    @Basic
    @Column(name = "image_url")
    private String imageUrl;

}
