package com.platts.oil.analytics.irr.uat.pages;

import net.serenitybdd.core.pages.PageObject;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class PlattsPageObject extends PageObject {

    public static String getComponentIdJsByRef(String xtype, String reference) {
        return "return Ext.ComponentQuery.query('"+xtype+"[reference="+reference+"]')[0].id";
    }

    public static String getComponentIdJsByItemId(String xtype, String itemId) {
        return "return Ext.ComponentQuery.query('"+xtype+"[itemId="+itemId+"]')[0].id";
    }

    public static String getComponentIdJsByXtype(String xtype) {
        return "return Ext.ComponentQuery.query('"+xtype+"')[0].id";
    }

    public static String getButtonIdJsBySelector(String selector, int item) {
        return "return Ext.ComponentQuery.query('"+selector+"')["+item+"].id";
    }

    public static String getComponentIdJsByItemIdWithPlaceholder(String xtype, String itemId) {
        return "return Ext.ComponentQuery.query('"+xtype+"[itemId="+itemId+"]')[%d].id";
    }

    public static String getComponentLengthJs(String xtype, String itemId) {
        return "return Ext.ComponentQuery.query('"+xtype+"[itemId="+itemId+"]').length";
    }

    public static String getComponentLengthJsByXtype(String xtype) {
        return "return Ext.ComponentQuery.query('"+xtype+"').length;";
    }

    public static String getComponentLengthJsByQuery(String query) {
        return "return Ext.ComponentQuery.query('"+query+"').length;";
    }

    public static String getComponentIdByQuery(String query) {
        return "return Ext.ComponentQuery.query('"+query+"')[0].id;";
    }

    public static String getComponentVisibilityByQuery(String query) {
        return "return Ext.ComponentQuery.query('"+query+"')[0].isVisible();";
    }

    public static String setTinyMceText(String editorText) {
        return "if(tinyMCE.activeEditor) { tinyMCE.activeEditor.setContent('"+editorText+"'); }";
    }

    public static String setTextAreaTextJs(String query) {
        return "Ext.ComponentQuery.query('"+query+"')[0].setValue('%s');";
    }

}
