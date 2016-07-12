package com.platts.oil.analytics.irr.uat.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by connor_hendrix on 7/8/2016.
 */
public class MessageBoxContent implements Question<String> {

    private String jsContentQuery;

    private MessageBoxContent() {}

    private MessageBoxContent(String jsContentQuery) {
        this.jsContentQuery = jsContentQuery;
    }

    public static MessageBoxContent displayed(String jsContentQuery) { return new MessageBoxContent(jsContentQuery); }

    public String answeredBy(Actor actor) {
        String content = (String) BrowseTheWeb.as(actor).evaluateJavascript(jsContentQuery);
        return content;
    }
}
