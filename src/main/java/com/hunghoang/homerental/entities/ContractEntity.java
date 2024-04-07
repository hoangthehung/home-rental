package com.hunghoang.homerental.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "contract", schema = "rental", catalog = "postgres")
public class ContractEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "properties_id")
    private int propertiesId;
    @Basic
    @Column(name = "owner_id")
    private int ownerId;
    @Basic
    @Column(name = "tenant_id")
    private int tenantId;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "deposit_amount")
    private Double depositAmount;
    @Basic
    @Column(name = "start_time_payment")
    private Integer startTimePayment;
    @Basic
    @Column(name = "notice_period")
    private Integer noticePeriod;
    @Basic
    @Column(name = "start_time")
    private Timestamp startTime;
    @Basic
    @Column(name = "end_time")
    private Timestamp endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropertiesId() {
        return propertiesId;
    }

    public void setPropertiesId(int propertiesId) {
        this.propertiesId = propertiesId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Integer getStartTimePayment() {
        return startTimePayment;
    }

    public void setStartTimePayment(Integer startTimePayment) {
        this.startTimePayment = startTimePayment;
    }

    public Integer getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(Integer noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractEntity that = (ContractEntity) o;
        return id == that.id && propertiesId == that.propertiesId && ownerId == that.ownerId && tenantId == that.tenantId && Double.compare(price, that.price) == 0 && Objects.equals(depositAmount, that.depositAmount) && Objects.equals(startTimePayment, that.startTimePayment) && Objects.equals(noticePeriod, that.noticePeriod) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertiesId, ownerId, tenantId, price, depositAmount, startTimePayment, noticePeriod, startTime, endTime);
    }
}
