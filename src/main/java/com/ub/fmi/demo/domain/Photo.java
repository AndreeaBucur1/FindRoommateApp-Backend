package com.ub.fmi.demo.domain;

import javax.persistence.*;

@Entity
@Table(name="photo")
public class Photo {

    @Id
    @GeneratedValue
    private Long id;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "propertyPostId")
    private PropertyPost propertyPost;

    public Photo() {

    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Photo(String photo) {
        this.photo = photo;
    }



    public Photo(String photo, PropertyPost propertyPost) {
        this.photo = photo;
        this.propertyPost = propertyPost;
    }
}
