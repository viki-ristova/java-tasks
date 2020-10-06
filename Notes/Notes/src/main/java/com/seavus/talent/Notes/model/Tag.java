package com.seavus.talent.Notes.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;


    @ManyToOne
    private User user;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag( String name, User user) {
        this.user=user;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
