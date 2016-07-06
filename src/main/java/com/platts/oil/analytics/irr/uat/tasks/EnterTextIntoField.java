package com.platts.oil.analytics.irr.uat.tasks;

import com.platts.oil.analytics.irr.uat.pages.ApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jonathan_cone on 6/21/2016.
 */
public class EnterTextIntoField implements Task {

    String inputText;
    String jsText;

    private ApplicationHomePage applicationHomePage;

    public EnterTextIntoField(String inputText, String jsText) {
        this.inputText = inputText;
        this.jsText = jsText;
    }

    @Step("{0} enter inputText into textField")
    public <T extends Actor> void performAs(T actor) {
        String id = (String) BrowseTheWeb.as(actor).evaluateJavascript(jsText);
        actor.attemptsTo(Enter.theValue(inputText).into("#"+id+" input"));
    }

    public static EnterTextIntoField thisTextForComponent(String inputText, String jsText) {
        return instrumented(EnterTextIntoField.class, inputText, jsText);
    }

}
