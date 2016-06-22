package com.platts.oil.analytics.irr.uat.tasks;

import com.platts.oil.analytics.irr.uat.pages.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class LoginToApp implements Task {

    private String username;
    private String password;

    public LoginToApp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Step("{0} logs into the application")
    public<T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterTextIntoField.thisTextForReference(username, LoginPage.EMAIL_TEXTFIELD_JS));
        actor.attemptsTo(EnterTextIntoField.thisTextForReference(password, LoginPage.PASSWORD_TEXTFIELD_JS));
        actor.attemptsTo(ClickSenchaButton.forComponent(LoginPage.LOGIN_BUTTON_JS));
    }

    public static LoginToApp withUsernameAndPassword(String username, String password) {
        return instrumented(LoginToApp.class, username, password);
    }

}
