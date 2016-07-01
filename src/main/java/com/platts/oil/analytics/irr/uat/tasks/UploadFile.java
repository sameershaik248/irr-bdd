package com.platts.oil.analytics.irr.uat.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;



/**
 * Created by jonathan_cone on 6/30/2016.
 */
public class UploadFile implements Task {

    String fileLocation;
    String jsText;

    private MarketInsightPage marketInsightPage;

    public UploadFile(String fileLocation, String jsText) {
        this.fileLocation = fileLocation;
        this.jsText = jsText;
    }

    @Step("{0} uploads file to Page")
    public<T extends Actor> void performAs(T actor) {
        String id = (String) BrowseTheWeb.as(actor).evaluateJavascript(jsText);
        BrowseTheWeb.as(actor).upload(fileLocation).to(Target.the("Upload file field").locatedBy("#"+id).resolveFor(actor));
    }

    public static UploadFile forLocation(String fileLocation, String jsText) {
        return instrumented(UploadFile.class, fileLocation, jsText);
    }

}
