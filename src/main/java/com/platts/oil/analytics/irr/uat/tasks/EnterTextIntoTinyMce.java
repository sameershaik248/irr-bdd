package com.platts.oil.analytics.irr.uat.tasks;

import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;


/**
 * Created by jonathan_cone on 7/6/2016.
 */
public class EnterTextIntoTinyMce implements Task {

    private String editorText;

    public EnterTextIntoTinyMce(String editorText) {
        this.editorText = editorText;
    }

    @Step("{0} enters text into the Tiny MCE Editor")
    public<T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).evaluateJavascript(MarketInsightPage.setTinyMceText(editorText));
    }

    public static EnterTextIntoTinyMce withText(String editorText) {
        return instrumented(EnterTextIntoTinyMce.class, editorText);
    }

}
