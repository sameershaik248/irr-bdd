package com.platts.oil.analytics.irr.uat.pages;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class MarketInsightPage extends PlattsPageObject {

    private static final String CURRENT_ARTICLE_HEADING_XTYPE = "container";
    private static final String CURRENT_ARTICLE_HEADING_REFERENCE = "title";
    public static final String CURRENT_ARTICLE_HEADING_JS =
            getComponentJs(CURRENT_ARTICLE_HEADING_XTYPE, CURRENT_ARTICLE_HEADING_REFERENCE);
    private static final String CURRENT_ARTICLE_DATE_XTYPE = "container";
    private static final String CURRENT_ARTICLE_DATE_REFERENCE = "publishedDate";
    public static final String CURRENT_ARTICLE_DATE_JS =
            getComponentJs(CURRENT_ARTICLE_DATE_XTYPE, CURRENT_ARTICLE_DATE_REFERENCE);
    private static final String CURRENT_ARTICLE_CONTENT_XTYPE = "container";
    private static final String CURRENT_ARTICLE_CONTENT_REFERENCE = "content";
    public static final String CURRENT_ARTICLE_CONTENT_JS =
            getComponentJs(CURRENT_ARTICLE_CONTENT_XTYPE, CURRENT_ARTICLE_CONTENT_REFERENCE);

}
