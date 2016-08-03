package com.platts.oil.analytics.irr.uat.tasks;

import com.platts.oil.analytics.irr.uat.model.AppPages;
import com.platts.oil.analytics.irr.uat.pages.LoginPage;
import com.platts.oil.analytics.irr.uat.pages.components.Navigation;
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
        AppPages result = null;
        if (isPanelVisible(actor, Navigation.MULTIPLAY_PAGE_XTYPE)) {
            result =  AppPages.MultiPlay;
        } else if (isPanelVisible(actor, Navigation.SINGLEPLAY_PAGE_XTYPE)) {
            result =  AppPages.SinglePlay;
        } else if (isPanelVisible(actor, Navigation.MARKET_INSIGHT_PAGE_XTYPE)) {
            result = AppPages.MarketInsight;
        } else if (isPanelVisible(actor, Navigation.LOGIN_PAGE_XTYPE)) {
            result =  AppPages.Login;
        }
        return result;
    }

    private boolean isPanelVisible(Actor actor, String xtype) {
        Long size = (Long) BrowseTheWeb.as(actor).evaluateJavascript
                ("return Ext.ComponentQuery.query('" + xtype + "').length;");
        if(size > 0) {
            return (boolean) BrowseTheWeb.as(actor).evaluateJavascript
                    ("return Ext.ComponentQuery.query('" + xtype + "')[0].isVisible();");
        }
        return false;
    }

}
