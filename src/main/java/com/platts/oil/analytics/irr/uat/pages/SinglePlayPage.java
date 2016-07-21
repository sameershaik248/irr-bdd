package com.platts.oil.analytics.irr.uat.pages;

/**
 * Created by jonathan_cone on 7/21/2016.
 */
public class SinglePlayPage extends PlattsPageObject {

    public static final String SINGLE_MENU(String well) {
        return getComponentIdByQuery("menuitem[playName="+well+"]");
    }

}
