package com.platts.oil.analytics.irr.uat.pages;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class MarketInsightPage extends PlattsPageObject {

    private static final String CURRENT_ARTICLE_TITLE_XTYPE = "container";
    private static final String CURRENT_ARTICLE_TITLE_REFERENCE = "title";
    public static final String CURRENT_ARTICLE_TITLE_JS =
            getComponentJs(CURRENT_ARTICLE_TITLE_XTYPE, CURRENT_ARTICLE_TITLE_REFERENCE);
    private static final String CURRENT_ARTICLE_DATE_XTYPE = "container";
    private static final String CURRENT_ARTICLE_DATE_REFERENCE = "publishedDate";
    public static final String CURRENT_ARTICLE_DATE_JS =
            getComponentJs(CURRENT_ARTICLE_DATE_XTYPE, CURRENT_ARTICLE_DATE_REFERENCE);
    private static final String CURRENT_ARTICLE_CONTENT_XTYPE = "container";
    private static final String CURRENT_ARTICLE_CONTENT_REFERENCE = "content";
    public static final String CURRENT_ARTICLE_CONTENT_JS =
            getComponentJs(CURRENT_ARTICLE_CONTENT_XTYPE, CURRENT_ARTICLE_CONTENT_REFERENCE);

    public static final String FIRST_INDEX_ARTICLE_JS =
            getButtonJs("marketanalysisindex analysisIndexPanel", 1);

    public static final String NUMBER_OF_ARTICLES_IN_INDEX =
            "return Ext.ComponentQuery.query('panel[xtype=marketanalysisindex]').length";

    public static String ARTICLE_ID_FOR_INDEX_ARTICLES =
            "return Ext.ComponentQuery.query('panel[xtype=marketanalysisindex]')[%d].articleId";

    public static String INDEX_ARTICLE_TITLE_JS =
            "return Ext.ComponentQuery.query('panel[xtype=marketanalysisindex] indexTitle')[%d].id";

    public static String INDEX_ARTICLE_DATE_JS =
            "return Ext.ComponentQuery.query('panel[xtype=marketanalysisindex] indexPubDate')[%d].id";

}
