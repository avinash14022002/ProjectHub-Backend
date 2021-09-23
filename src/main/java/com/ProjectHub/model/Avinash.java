package com.ProjectHub.model;

import javax.persistence.*;

/**
 * Created by Avinash Vijayvargiya on 22-09-2021.
 */
@Entity
@Table(name = "Avinash")
public class Avinash {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;


    public Avinash(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public Avinash() {

    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}
