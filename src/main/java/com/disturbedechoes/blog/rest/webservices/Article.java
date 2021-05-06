package com.disturbedechoes.blog.rest.webservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String title;
    private String description;
    private boolean published;
    private Date lastChangeDate;

    protected Article() {
    }

    public Article(Long id, String username, String title, String description, boolean published, Date lastChangeDate) {
        super();
        this.id = id;
        this.username = username;
        this.title = title;
        this.description = description;
        this.published = published;
        this.lastChangeDate = lastChangeDate;
    }

    @Override
    public boolean equals(Object obj) {
        if ( ((Article) obj).id !=  id) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                ", lastDate=" + lastChangeDate +
                '}';
    }
}
