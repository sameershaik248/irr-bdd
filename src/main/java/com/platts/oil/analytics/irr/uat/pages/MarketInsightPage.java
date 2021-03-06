package com.platts.oil.analytics.irr.uat.pages;

import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
@DefaultUrl("http://nj09mhf5996.mhf.mhc:7001/irr/")
public class MarketInsightPage extends PlattsPageObject {

    private static final String CURRENT_ARTICLE_TITLE_XTYPE = "label";
    private static final String CURRENT_ARTICLE_TITLE_REFERENCE = "title";
    public static final String CURRENT_ARTICLE_TITLE_JS =
            getComponentIdJsByRef(CURRENT_ARTICLE_TITLE_XTYPE, CURRENT_ARTICLE_TITLE_REFERENCE);

    private static final String CURRENT_ARTICLE_DATE_XTYPE = "container";
    private static final String CURRENT_ARTICLE_DATE_REFERENCE = "analysisDate";
    public static final String CURRENT_ARTICLE_DATE_JS =
            getComponentIdJsByRef(CURRENT_ARTICLE_DATE_XTYPE, CURRENT_ARTICLE_DATE_REFERENCE);

    private static final String CURRENT_ARTICLE_CONTENT_XTYPE = "container";
    private static final String CURRENT_ARTICLE_CONTENT_REFERENCE = "content";
    public static final String CURRENT_ARTICLE_CONTENT_JS =
            getComponentIdJsByRef(CURRENT_ARTICLE_CONTENT_XTYPE, CURRENT_ARTICLE_CONTENT_REFERENCE);

    public static final String CURRENT_ARTICLE_ARTICLE_ID =
            "return Ext.ComponentQuery.query('container[reference=mainAnalysisPanel]')[0].articleId;";

    public static String articleForIndex(Integer index) {
        return getButtonIdJsBySelector("marketanalysisindex", index);
    }

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
    public static final String POST_ARTICLE_ID_JS =
            getComponentIdJsByItemId("button", POST_ARTICLE_BUTTON_ITEMID);

    // Delete article button
    private static final String DELETE_ARTICLE_BUTTON_ITEMID = "deleteMarketInsightArticle";
    public static final String DELETE_ARTICLE_LENGTH_JS =
            getComponentLengthJs("button", DELETE_ARTICLE_BUTTON_ITEMID);
    public static final String DELETE_ARTICLE_ID_JS =
            getComponentIdJsByItemId("button", DELETE_ARTICLE_BUTTON_ITEMID);

    // Confirm delete article button
    private static final String CONFIRM_DELETE_ARTICLE_BUTTON_QUERY = "messagebox button[itemId=yes]";
    public static final String CONFIRM_DELETE_ARTICLE_LENGTH_JS =
            getComponentLengthJsByQuery(CONFIRM_DELETE_ARTICLE_BUTTON_QUERY);
    public static final String CONFIRM_DELETE_ARTICLE_ID_JS =
            getComponentIdByQuery(CONFIRM_DELETE_ARTICLE_BUTTON_QUERY);

    // Messagebox
    private static final String MESSAGEBOX_QUERY = "messagebox";
    public static final String MESSAGEBOX_VISIBILITY_JS =
            getComponentVisibilityByQuery(MESSAGEBOX_QUERY);
    public static final String MESSAGE_BOX_CONTENT_JS = "return Ext.ComponentQuery.query(\"messagebox\")[0].msg.html";

    // Close Editor
    public static final String CLOSE_EDITOR_JS = "return Ext.ComponentQuery.query('marketanalysiseditor')[0].close();";

    // Confirm delete article button
    private static final String CONFIRM_ERROR_NOTICE_BUTTON_QUERY = "messagebox button[itemId=ok]";
    public static final String CONFIRM_ERROR_NOTICE_ID_JS =
            getComponentIdByQuery(CONFIRM_ERROR_NOTICE_BUTTON_QUERY);

    // Article Editor Window
    private static final String ARTICLE_EDITOR_WINDOW_XTYPE = "marketanalysiseditor";
    public static final String ARTICLE_EDITOR_WINDOW_LENGTH_JS =
            getComponentLengthJsByXtype(ARTICLE_EDITOR_WINDOW_XTYPE);
    public static final String ARTICLE_EDITOR_WINDOW_ID_JS =
            getComponentIdJsByXtype(ARTICLE_EDITOR_WINDOW_XTYPE);

    // Article Editor Title Field
    private static final String ARTICLE_EDITOR_TITLE_QUERY = "marketanalysiseditor textfield[itemId=marketanalysistitle]";
    public static final String ARTICLE_EDITOR_TITLE_JS =
            getComponentIdByQuery(ARTICLE_EDITOR_TITLE_QUERY);

    // Article Exerpt Textarea Field
    private static final String ARTICLE_EDITOR_EXERPT_QUERY = "marketanalysiseditor textarea[itemId=marketanalysisexerpt]";
    public static final String ARTICLE_EDITOR_EXERPT_JS =
            getComponentIdByQuery(ARTICLE_EDITOR_EXERPT_QUERY);

    // Article Publish Button
    private static final String ARTICLE_EDITOR_PUBLISH_QUERY = "marketanalysiseditor button[itemId=marketanalysispublish]";
    public static final String ARTICLE_EDITOR_PUBLISH_JS =
            getComponentIdByQuery(ARTICLE_EDITOR_PUBLISH_QUERY);

    // Get the article JS for a specific index


}
