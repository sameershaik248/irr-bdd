package com.platts.oil.analytics.irr.uat.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan_cone on 6/21/2016.
 */
public class PlattsSenchaQuery extends PageObject {

    public String getIdForSenchaXtypeAndReference(String xtype, String reference) {
        return (String) evaluateJavascript("return Ext.ComponentQuery.query('" + xtype + "[reference=" +
                                reference + "]')[0].id;");
    }

    public String getIdForSenchaXtypeAndItemid(String xtype, String itemId) {
        return (String) evaluateJavascript("return Ext.ComponentQuery.query('" + xtype + "[reference=" +
                itemId + "]')[0].id;");
    }

    public boolean isPanelVisible(String xtype) {
        Long size = (Long) evaluateJavascript("return Ext.ComponentQuery.query('" + xtype + "').length;");
        if(size > 0) {
            return (boolean) evaluateJavascript("return Ext.ComponentQuery.query('" + xtype + "')[0].isVisible();");
        }
        return false;
    }

}
