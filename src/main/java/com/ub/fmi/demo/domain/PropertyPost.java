package com.ub.fmi.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="property_post")
public class PropertyPost {
    @Id
    @GeneratedValue
    Long id;

    @Column
    String title;

    @Column
    String propertyType;

    @Column
    Boolean isForSale;

    @Column
    Integer numberOfRooms;

    @Column
    Integer numberOfBathrooms;

    @Column
    Integer floor;

    @Column
    Integer surface;

    @Column
    Boolean hasParkingSpot;

    @Column
    Boolean hasElevator;

    @Column
    String city;

    @Column
    Integer buildYear;

    @Column
    Integer price;

    @Column
    String description;

    @Column
    LocalDateTime creationDate;

    @Column
    String mainImage;

    @JsonIgnore
    @OneToMany(mappedBy = "propertyPost")
    private List<Photo> photos;

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Boolean getForSale() {
        return isForSale;
    }

    public void setForSale(Boolean forSale) {
        isForSale = forSale;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public Boolean getHasParkingSpot() {
        return hasParkingSpot;
    }

    public void setHasParkingSpot(Boolean hasParkingSpot) {
        this.hasParkingSpot = hasParkingSpot;
    }

    public Boolean getHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(Boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    public Integer getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Integer buildYear) {
        this.buildYear = buildYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getIsForSale() {
        return isForSale;
    }

    public void setIsForSale(Boolean isForSale) {
        this.isForSale = isForSale;
    }

    @Override
    public String toString() {
        return "PropertyPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", isForSale=" + isForSale +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", floor=" + floor +
                ", surface=" + surface +
                ", hasParkingSpot=" + hasParkingSpot +
                ", hasElevator=" + hasElevator +
                ", buildYear=" + buildYear +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", user=" + user +
                '}';
    }
}
