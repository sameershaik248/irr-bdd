package com.platts.oil.analytics.irr.uat.tasks;

import com.platts.oil.analytics.irr.uat.pages.ApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class OpenAnApp implements Task {

    private String app;
    private ApplicationHomePage applicationHomePage;

    public OpenAnApp(String app) { this.app = app; }

    @Step("{0} opens the application")
    public<T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(applicationHomePage));
    }

    public static OpenAnApp theApp(String app) { return instrumented(OpenAnApp.class, app); }

}
