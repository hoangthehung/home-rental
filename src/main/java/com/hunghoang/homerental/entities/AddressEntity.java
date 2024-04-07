package com.hunghoang.homerental.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "address", schema = "rental", catalog = "postgres")
public class AddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "ward")
    private String ward;
    @Basic
    @Column(name = "district")
    private String district;
    @Basic
    @Column(name = "province")
    private String province;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "postcode")
    private String postcode;
    @Basic
    @Column(name = "latitude")
    private Double latitude;
    @Basic
    @Column(name = "longitude")
    private Double longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return id == that.id && Objects.equals(street, that.street) && Objects.equals(ward, that.ward) && Objects.equals(district, that.district) && Objects.equals(province, that.province) && Objects.equals(country, that.country) && Objects.equals(postcode, that.postcode) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, ward, district, province, country, postcode, latitude, longitude);
    }
}
