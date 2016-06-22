package com.platts.oil.analytics.irr.uat.tasks;

import com.platts.oil.analytics.irr.uat.model.AppPages;
import com.platts.oil.analytics.irr.uat.pages.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class DisplayedPage implements Question<AppPages> {

    public static DisplayedPage theDisplayedPage() {
        return new DisplayedPage();
    }

    @Override
    public AppPages answeredBy(Actor actor) {
        AppPages result;
        if (isPanelVisible(actor, LoginPage.MULTIPLAY_PAGE_XTYPE)) {
            result =  AppPages.MultiPlay;
        } else if (isPanelVisible(actor, LoginPage.SINGLEPLAY_PAGE_XTYPE)) {
            result =  AppPages.SinglePlay;
        } else {
            result =  AppPages.Login;
        }
        return result;
    }

    private boolean isPanelVisible(Actor actor, String xtype) {
        Long size = (Long) BrowseTheWeb.as(actor).evaluateJavascript("return Ext.ComponentQuery.query('" + xtype + "').length;");
        if(size > 0) {
            return (boolean) BrowseTheWeb.as(actor).evaluateJavascript("return Ext.ComponentQuery.query('" + xtype + "')[0].isVisible();");
        }
        return false;
    }

}
