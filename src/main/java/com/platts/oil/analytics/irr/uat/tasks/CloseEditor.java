package com.platts.oil.analytics.irr.uat.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by connor_hendrix on 6/22/2016.
 */
public class CloseEditor implements Task {

    private String closeJs;

    public CloseEditor(String closeJs) {
        this.closeJs = closeJs;
    }

    public<T extends Actor> void performAs(T actor) {
         BrowseTheWeb.as(actor).evaluateJavascript(this.closeJs);
    }

    public static CloseEditor forComponent(String closeJs) {
        return instrumented(CloseEditor.class, closeJs);
    }

}
