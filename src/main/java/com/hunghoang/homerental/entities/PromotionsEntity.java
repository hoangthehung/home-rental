package com.hunghoang.homerental.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "promotions", schema = "rental", catalog = "postgres")
public class PromotionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "expired_time")
    private Timestamp expiredTime;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "value")
    private Double value;
    @Basic
    @Column(name = "owner_by")
    private Integer ownerBy;
    @Basic
    @Column(name = "used_by")
    private Integer usedBy;
    @Basic
    @Column(name = "created")
    private Timestamp created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Timestamp expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getOwnerBy() {
        return ownerBy;
    }

    public void setOwnerBy(Integer ownerBy) {
        this.ownerBy = ownerBy;
    }

    public Integer getUsedBy() {
        return usedBy;
    }

    public void setUsedBy(Integer usedBy) {
        this.usedBy = usedBy;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionsEntity that = (PromotionsEntity) o;
        return id == that.id && Objects.equals(code, that.code) && Objects.equals(expiredTime, that.expiredTime) && Objects.equals(type, that.type) && Objects.equals(value, that.value) && Objects.equals(ownerBy, that.ownerBy) && Objects.equals(usedBy, that.usedBy) && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, expiredTime, type, value, ownerBy, usedBy, created);
    }
}
