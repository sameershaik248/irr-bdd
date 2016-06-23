package com.platts.oil.analytics.irr.uat.pages;

import net.serenitybdd.core.pages.PageObject;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class PlattsPageObject extends PageObject {

    public static String getComponentJs(String xtype, String reference) {
        return "return Ext.ComponentQuery.query('"+xtype+"[reference="+reference+"]')[0].id";
    }

    public static String getButtonJs(String selector, int item) {
        return "return Ext.ComponentQuery.query('"+selector+"')["+item+"]";
    }

    public static String getButtonFromItemIdJs(String xtype, String itemId) {
        return "return Ext.ComponentQuery.query('"+xtype+"[itemId="+itemId+"]')[0].id";
    }

}
