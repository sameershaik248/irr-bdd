package com.platts.oil.analytics.irr.uat.jbehave.stepdefinitions;

import com.platts.oil.analytics.irr.uat.model.AppPages;
import com.platts.oil.analytics.irr.uat.questions.DisplayedPage;
import com.platts.oil.analytics.irr.uat.tasks.LoginToApp;
import com.platts.oil.analytics.irr.uat.tasks.OpenAnApp;

import com.platts.oil.analytics.irr.uat.utils.DatabaseTools;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;


import static com.platts.oil.analytics.irr.uat.model.Actors.theActorNamed;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by jonathan_cone on 6/21/2016.
 */
public class LoginStepDefinitions {

    @Managed
    WebDriver janesBrowser;

    @Steps DisplayedPage theDisplayedPage;

    @BeforeStories
    public void beforeStories() throws Throwable {
        DatabaseTools.INSTANCE.connectToDb();
        DatabaseTools.INSTANCE.createSnapshotAndLoadTestData();
    }

    @AfterStories
    public void afterStories() throws Throwable {
        DatabaseTools.INSTANCE.restoreSnapshot();
        DatabaseTools.INSTANCE.closeDbConnection();
    }

    @Given("$actor opens the WEA application")
    public void i_open_the_app_application(String actor) throws Throwable {
        theActorNamed(actor).can(BrowseTheWeb.with(theBrowserBelongingTo(actor)));
        theActorNamed(actor).attemptsTo(OpenAnApp.theApp("WEA"));
    }

    @When("$actor inputs username $username and password $password")
    public void i_input_username_and_password(String actor, String username, String password) throws Throwable {
        theActorNamed(actor).attemptsTo(LoginToApp.withUsernameAndPassword(username, password));
    }

    @Then("$actor should see the $view view")
    public void i_should_see_the_view(String actor, String view) throws Throwable {
        theActorNamed(actor).should(seeThat(theDisplayedPage, equalTo(AppPages.MultiPlay)));
    }

    private WebDriver theBrowserBelongingTo(String actor) {
        switch (actor) {
            case "jane" :
                return janesBrowser;
            default:
                return janesBrowser;
        }
    }
}
