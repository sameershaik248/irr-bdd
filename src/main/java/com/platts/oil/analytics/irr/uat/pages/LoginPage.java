package com.platts.oil.analytics.irr.uat.pages;

import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by jonathan_cone on 6/21/2016.
 */
@DefaultUrl("http://localhost:8080/irr")
public class LoginPage extends PlattsPageObject {

    public static final String EMAIL_TEXTFIELD_REFERENCE = "userid";
    public static final String EMAIL_TEXTFIELD_XTYPE = "textfield";
    public static final String EMAIL_TEXTFIELD_JS = getComponentIdJsByRef(EMAIL_TEXTFIELD_XTYPE, EMAIL_TEXTFIELD_REFERENCE);
    public static final String PASSWORD_TEXTFIELD_REFERENCE = "password";
    public static final String PASSWORD_TEXTFIELD_XTYPE = "textfield";
    public static final String PASSWORD_TEXTFIELD_JS = getComponentIdJsByRef(PASSWORD_TEXTFIELD_XTYPE, PASSWORD_TEXTFIELD_REFERENCE);
    public static final String LOGIN_BUTTON_REFERENCE = "loginButton";
    public static final String LOGIN_BUTTON_XTYPE = "button";
    public static final String LOGIN_BUTTON_JS = getComponentIdJsByRef(LOGIN_BUTTON_XTYPE, LOGIN_BUTTON_REFERENCE);

}
