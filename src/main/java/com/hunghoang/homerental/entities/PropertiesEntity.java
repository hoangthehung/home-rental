package com.hunghoang.homerental.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "properties", schema = "rental", catalog = "postgres")
public class PropertiesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "address_id")
    private int addressId;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "size")
    private Double size;
    @Basic
    @Column(name = "target_customer")
    private String targetCustomer;
    @Basic
    @Column(name = "facilities")
    private String facilities;
    @Basic
    @Column(name = "num_paxs")
    private Integer numPaxs;
    @Basic
    @Column(name = "num_beds")
    private Integer numBeds;
    @Basic
    @Column(name = "num_toilets")
    private Integer numToilets;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "owner_id")
    private int ownerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTargetCustomer() {
        return targetCustomer;
    }

    public void setTargetCustomer(String targetCustomer) {
        this.targetCustomer = targetCustomer;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public Integer getNumPaxs() {
        return numPaxs;
    }

    public void setNumPaxs(Integer numPaxs) {
        this.numPaxs = numPaxs;
    }

    public Integer getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(Integer numBeds) {
        this.numBeds = numBeds;
    }

    public Integer getNumToilets() {
        return numToilets;
    }

    public void setNumToilets(Integer numToilets) {
        this.numToilets = numToilets;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertiesEntity that = (PropertiesEntity) o;
        return id == that.id && addressId == that.addressId && Double.compare(price, that.price) == 0 && ownerId == that.ownerId && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(size, that.size) && Objects.equals(targetCustomer, that.targetCustomer) && Objects.equals(facilities, that.facilities) && Objects.equals(numPaxs, that.numPaxs) && Objects.equals(numBeds, that.numBeds) && Objects.equals(numToilets, that.numToilets) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addressId, type, price, size, targetCustomer, facilities, numPaxs, numBeds, numToilets, description, ownerId);
    }
}
