package com.platts.oil.analytics.irr.uat.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class ClickSenchaButton implements Task {

    private String jsText;

    public ClickSenchaButton(String jsText) {
        this.jsText = jsText;
    }

    @Step("{0} clicks a button on the app")
    public<T extends Actor> void performAs(T actor) {
        String id = (String) BrowseTheWeb.as(actor).evaluateJavascript(jsText);
        actor.attemptsTo(Click.on("#"+id));
    }

    public static ClickSenchaButton forComponent(String jsText) {
        return instrumented(ClickSenchaButton.class, jsText);
    }

}
