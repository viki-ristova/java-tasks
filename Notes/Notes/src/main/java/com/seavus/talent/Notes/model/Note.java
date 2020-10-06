package com.seavus.talent.Notes.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<Tag> tags;

    public Note() {

    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Note(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user=user;
    }

    public Note(String title, String content, User user, List<Tag> tags) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.tags = tags;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Note{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
