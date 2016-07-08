package com.platts.oil.analytics.irr.uat.model;

import java.util.Date;

/**
 * Created by connor_hendrix on 6/22/2016.
 */
public class MarketAnalysisData {

    private String id;
    private String slug;
    private String author;
    private String title;
    private String body;
    private Date publishedDate;
    private boolean active;

    public MarketAnalysisData() {}

    public MarketAnalysisData(String id, String slug, String author, String title, Date published_date, boolean active) {
        this.id = id;
        this.slug = slug;
        this.author = author;
        this.title = title;
        this.publishedDate = published_date;
        this.active = active;
    }

    public boolean equals(MarketAnalysisData b) {
       boolean returnBool = this.id.equals(b.id) && this.title.equals(b.title);
               //&& this.publishedDate.equals(b.publishedDate);
        return returnBool;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublished_date() {
        return publishedDate;
    }

    public void setPublishedDate(Date published_date) {
        this.publishedDate = published_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public Date getPublishedDate() { return publishedDate; }


}
