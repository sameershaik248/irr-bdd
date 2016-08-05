package com.platts.oil.analytics.irr.uat.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by jonathan_cone on 7/1/2016.
 */
public class ComponentDisplayed implements Question<Boolean> {

    private String jsTextId;
    private String jsTextLength;

    private ComponentDisplayed() {}

    private ComponentDisplayed(String jsTextLength, String jsTextId) {
        this.jsTextId = jsTextId;
        this.jsTextLength = jsTextLength;
    }

    public static ComponentDisplayed displayed(String jsTextLength, String jsTextId) { return new ComponentDisplayed(jsTextLength, jsTextId); }

    public Boolean answeredBy(Actor actor) {
        boolean displayed = false;
        if ((Long) BrowseTheWeb.as(actor).evaluateJavascript(jsTextLength) > 0) {
            String id = (String) BrowseTheWeb.as(actor).evaluateJavascript(jsTextId);
            displayed = Visibility.of(Target.the("Sencha Component").locatedBy("#"+id)).viewedBy(actor).as(Boolean.class);
        }
        return displayed;
    }

}
