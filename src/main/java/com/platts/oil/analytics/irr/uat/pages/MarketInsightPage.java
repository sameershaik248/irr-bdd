package com.platts.oil.analytics.irr.uat.pages;

import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
@DefaultUrl("http://nj09mhf5996.mhf.mhc:7001/irr/")
public class MarketInsightPage extends PlattsPageObject {

    private static final String CURRENT_ARTICLE_TITLE_XTYPE = "container";
    private static final String CURRENT_ARTICLE_TITLE_REFERENCE = "title";
    public static final String CURRENT_ARTICLE_TITLE_JS =
            getComponentIdJsByRef(CURRENT_ARTICLE_TITLE_XTYPE, CURRENT_ARTICLE_TITLE_REFERENCE);

    private static final String CURRENT_ARTICLE_DATE_XTYPE = "container";
    private static final String CURRENT_ARTICLE_DATE_REFERENCE = "publishedDate";
    public static final String CURRENT_ARTICLE_DATE_JS =
            getComponentIdJsByRef(CURRENT_ARTICLE_DATE_XTYPE, CURRENT_ARTICLE_DATE_REFERENCE);

    private static final String CURRENT_ARTICLE_CONTENT_XTYPE = "container";
    private static final String CURRENT_ARTICLE_CONTENT_REFERENCE = "content";
    public static final String CURRENT_ARTICLE_CONTENT_JS =
            getComponentIdJsByRef(CURRENT_ARTICLE_CONTENT_XTYPE, CURRENT_ARTICLE_CONTENT_REFERENCE);

    public static final String CURRENT_ARTICLE_ARTICLE_ID =
            "return Ext.ComponentQuery.query('container[reference=mainAnalysisPanel]')[0].articleId;";

    public static final String FIRST_INDEX_ARTICLE_JS =
            getButtonIdJsBySelector("marketanalysisindex", 1);

    public static final String NUMBER_OF_ARTICLES_IN_INDEX =
            "return Ext.ComponentQuery.query('marketanalysisindex').length";

    public static String ARTICLE_ID_FOR_INDEX_ARTICLES =
            "return Ext.ComponentQuery.query('marketanalysisindex')[%d].articleId";

    public static String INDEX_ARTICLE_TITLE_JS =
            getComponentIdJsByItemIdWithPlaceholder("panel", "indexTitle");

    public static String INDEX_ARTICLE_DATE_JS =
            getComponentIdJsByItemIdWithPlaceholder("panel", "indexPubDate");

    public static String INDEX_ARTICLE_VISIBLE_JS =
            "return Ext.ComponentQuery.query('marketanalysisindex')[%d].isVisible();";

    // Post article button
    private static final String POST_ARTICLE_BUTTON_ITEMID = "postMarketInsightArticle";
    public static final String POST_ARTICLE_LENGTH_JS =
            getComponentLengthJs("button", POST_ARTICLE_BUTTON_ITEMID);
    public static final String POST_ARTICLE_VISIBLE_JS =
            getComponentVisibleJs("button", POST_ARTICLE_BUTTON_ITEMID);
    public static final String POST_ARTICLE_ID_JS =
            getComponentIdJsByItemId("button", POST_ARTICLE_BUTTON_ITEMID);

}
