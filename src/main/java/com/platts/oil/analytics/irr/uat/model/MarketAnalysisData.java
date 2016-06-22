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
    private Date published_date;
    private boolean active;

    public MarketAnalysisData(String id, String slug, String author, String title, Date published_date, boolean active) {
        this.id = id;
        this.slug = slug;
        this.author = author;
        this.title = title;
        this.published_date = published_date;
        this.active = active;
    }

    public boolean equals(MarketAnalysisData b) {
       boolean returnBool = this.id.equals(b.id) && this.title.equals(b.title) && this.published_date.equals(b.published_date);
        return returnBool;
    }

}
