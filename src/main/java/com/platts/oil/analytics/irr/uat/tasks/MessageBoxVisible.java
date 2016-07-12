package com.platts.oil.analytics.irr.uat.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by connor_hendrix on 7/8/2016.
 */
public class MessageBoxVisible implements Question<Boolean> {

    private String jsVisibilityQuery;

    private MessageBoxVisible() {}

    private MessageBoxVisible(String jsVisibilityQuery) {
        this.jsVisibilityQuery = jsVisibilityQuery;
    }

    public static MessageBoxVisible displayed(String jsVisibilityQuery) { return new MessageBoxVisible(jsVisibilityQuery); }

    public Boolean answeredBy(Actor actor) {
        return ((Boolean) BrowseTheWeb.as(actor).evaluateJavascript(jsVisibilityQuery));
    }
}
